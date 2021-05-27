package 马拉车;

/**
 * @author 王文
 * @version : V1.0
 * @className: Manacher
 * @description: manacher算法
 * @date 2021-05-25
 */
public class Manacher {
    public static int manacher(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        //改造字符串  1234321 -> #1#2#3#4#3#2#1
        char[] chars = manacherString(str);
        //回文半径的大小
        int[] pArr = new int[chars.length];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            //R第一个违规的位置，i>=R
            //i位置扩出来的答案，i位置扩的区域，至少是多大
            pArr[i] = i >= R ? 1 : Math.min(pArr[2 * C - i], R - i);

            while (i + pArr[i] < chars.length && i - pArr[i] > -1) {
                if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }

            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max-1;
    }

    private static char[] manacherString(String str) {
        char[] chars = str.toCharArray();
        char[] manacherChar = new char[chars.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < manacherChar.length; i++) {
            manacherChar[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return manacherChar;
    }

    public static void main(String[] args) {
        String s="asdaadsa231132asd";
        System.out.println(manacher(s));
    }
}
