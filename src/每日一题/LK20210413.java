package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20210413
 * @description: 给你一个二叉搜索树的根节点root ，返回 树中任意两不同节点值之间的最小差值 。
 * @date 2021-04-13
 */


/**
 * 本题难点，将数据树状化，利用搜素树中序有序的特点，将节点值遍历并排序，找出最小差值。
 */

public class LK20210413 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int res = Integer.MAX_VALUE;
    public Node pre = null;

    public int getMinDistance(Node node) {
        //二叉树的递归遍历
        this.f(node);
        return res;
    }

    public void f(Node head) {
        if (head == null) {
            return;
        }
        //1 (先序）
        f(head.left);
        if (pre != null) {
            res = Math.min(res, head.value - pre.value);
        }
        pre = head;
        //2 (中序)
        f(head.right);
        //3 (后序)
    }
}
