package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211118
 * @description: 二叉树的坡度
 * @date 2021-11-18
 */
public class Lk20211118 {
    public int findTilt(TreeNode root) {
        int[] res = new int[1];
        process(root, res);
        return res[0];
    }

    private int process(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left, res);
        int right = process(root.right, res);
        res[0] += Math.abs(left - right);
        return left + right + root.val;
    }

    public class TreeNode {
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
}
