package kmp;

import java.util.ArrayList;

/**
 * @author 王文
 * @version : V1.0
 * @className: TreeEqual
 * @description: 一颗树在另一颗树中是否有相同结构
 * @date 2021-05-19
 */
public class TreeEqual {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    /**
     * @Author 王文
     * @Description 暴力的方法：递归暴力解  O(N*M)
     * @Date 2021/5/19
     * @Param [big, small]
     * @return boolean
     **/
    //big做头节点的树，其中是否有某颗子树的结构，是和small为头的树，是完全一样的
    public static boolean containsTree1(Node big, Node small) {
        //small为空
        if (small == null) {
            return true;
        }
        //big为空
        if (big == null) {
            return false;
        }
        if (isSameValueStructure(big, small)) {
            return true;
        }
        return containsTree1(big.left, small) || containsTree1(big.right, small);
    }

    //head1为头的树，是否在结构对应上，完全和head2一样
    private static boolean isSameValueStructure(Node head1, Node head2) {
        if (head1 == null && head2 != null) {
            return false;
        }
        if (head1 != null && head2 == null) {
            return false;
        }
        if (head1 == null) {
            return true;
        }
        return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
    }


    /**
     * @Author 王文
     * @Description KMP方法  O(N)
     * @Date 2021/5/19
     * @Param [big, small]
     * @return boolean
     **/
    public static boolean containTree2(Node big, Node small) {
        if (small == null) {
            return true;
        }
        if (big == null) {
            return false;
        }
        ArrayList<String> b = preSerial(big);
        ArrayList<String> s = preSerial(small);
        String[] str = new String[b.size()];
        String[] match = new String[s.size()];
        for (int i = 0; i < b.size(); i++) {
            str[i] = b.get(i);
        }
        for (int i = 0; i < s.size(); i++) {
            match[i] = s.get(i);
        }
        return getIndexOf(str, match) != -1;
    }

    //KMP实现
    private static int getIndexOf(String[] str, String[] match) {
        if (str == null || match == null || str.length < 1 || match.length > str.length) {
            return -1;
        }
        int x = 0;
        int y = 0;
        int[] next = getNextArray(match);
        while (x < str.length && y < match.length) {
            if (str[x].equals(match[y])) {
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

    //获取next数组：最长前缀和后缀相等数
    private static int[] getNextArray(String[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }
        if (match.length == 2) {
            return new int[]{-1, 0};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i=2;
        //cn代表，cn位置的字符，是当前和i-1位置比较的字符
        int cn=0;
        while(i<next.length){
            if(match[i - 1].equals(match[next[i]])){
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

    private static ArrayList<String> preSerial(Node head) {
        ArrayList<String> ans = new ArrayList<>();
        pres(head, ans);
        return ans;
    }

    private static void pres(Node head, ArrayList<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }
}
