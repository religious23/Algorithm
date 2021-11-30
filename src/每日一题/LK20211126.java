package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211127
 * @description: 二叉搜索树中的搜索
 * @date 2021-11-26
 */
public class LK20211126 {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (root.val < val) {
                root = root.right;
            } else if (root.val > val) {
                root = root.left;
            }
        }
        return null;
    }
}
