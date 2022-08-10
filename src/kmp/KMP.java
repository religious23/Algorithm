package kmp;

/**
 * @author 王文
 * @version : V1.0
 * @className: KMP
 * @description: KMP算法
 * @date 2021-05-16
 */

/**
 * 对KMP算法的理解
 * 1：从左到右
 * 2：让每一个位置的比对都具有意义（回跳的力度降到最低）
 */
public class KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        //x代表 str中的当前比对位置
        int x = 0;
        //y代表 match中当前比对位置
        int y = 0;
        int[] next = getNextArray(match);
        while (x < str.length && y < match.length) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == match.length ? x - y : -1;
    }

    //M O(M)
    private static int[] getNextArray(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i=2;
        //cn代表，cn位置的字符，是当前和i-1位置比较的字符
        int cn=0;
        while(i<next.length){
            if(match[i-1]==match[cn]){
                //跳出来的时候
                next[i++]=++cn;
            }
            else if(cn>0){
                cn=next[cn];
            }
            else{
                next[i++]=0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str="seafekgse1243jdhsgfdgdhgfdfshgdfgsrjsyrjuykugldfgdfekge123jdhgdhfgseshygdmvdfgdghskso";
        String match="ekge1523jdh";
        System.out.println(getIndexOf(str, match));
    }
}
