package 每日一题;

import java.util.Stack;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211017
 * @description: 二叉搜索树中第k小的元素
 * @date 2021-10-17
 */
public class LK20211017 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * @Author W.Wen
     * @Description 递归版本
     * @Date 2021/10/17
     * @Param [cur, k]
     * @return void
     **/
    public static void kthSmallest(TreeNode cur, Res k) {
        if (cur == null) {
            return;
        }
        //1 (先序）
        kthSmallest(cur.left, k);
        //2 (中序)
        k.k--;
        if (k.k == 0) {
            k.v = cur.val;
        }
        kthSmallest(cur.right, k);
        //3 (后序)
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(2, node1, node3);
        Res k = new Res(1, 0);
        kthSmallest(node2, k);
        System.out.println(k.v);
        //System.out.println(res);
    }

    public static class Res {
        private Integer k;
        private Integer v;

        public Res(Integer k, Integer v) {
            this.k = k;
            this.v = v;
        }
    }


    /**
     * @Author W.Wen
     * @Description 非递归版本
     * @Date 2021/10/17
     * @Param
     * @return null
     **/
    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        k--;
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (k == 0) {
                        res = root.val;
                    }
                    k--;
                    root = root.right;
                }
            }
        }
        return res;
    }
}