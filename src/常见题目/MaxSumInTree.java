package 常见题目;

/**
 * @author 王文
 * @version : V1.0
 * @className: MaxSumInTree
 * @description: 关于二叉树的最大路径和问题三连
 * @date 2021-08-14
 */

/**
 * 给定一个二叉树的头节点head,求最大路径和
 */

public class MaxSumInTree {

    public static int maxPath;

    public static class Node {
        private int value;
        private Node right;
        private Node left;
    }

    public static class Info {
        public int allTreeMaxSum;
        public int formHeadMaxSum;

        public Info(int all, int from) {
            this.allTreeMaxSum = all;
            this.formHeadMaxSum = from;
        }
    }

    /**
     * @return int
     * @Author 王文
     * @Description 问题一：路径必须是头节点出发，到叶节点为止，返回最大路径和
     * @Date 2021/8/14
     * @Param [head]
     **/
    public static int getMaxPath(Node head) {
        maxPath = Integer.MIN_VALUE;
        process(head, 0);
        return maxPath;
    }

    /**
     * @return int
     * @Author 王文
     * @Description 问题一：路径必须是头节点出发，到叶节点为止，返回最大路径和 （二叉树递归套路）
     * @Date 2021/8/14
     * @Param [head]
     **/
    public static int getMaxPath2(Node head) {
        return process2(head);
    }

    private static int process2(Node head) {
        if (head.right == null && head.left == null) {
            return head.value;
        }
        int minPath2 = Integer.MIN_VALUE;
        if (head.right != null) {
            minPath2 = process2(head.right);
        }
        if (head.left != null) {
            minPath2 = Math.max(minPath2, process2(head.left));
        }
        return minPath2 + head.value;
    }

    private static void process(Node head, int i) {
        if (head.left == null && head.right == null) {
            maxPath = Math.max(maxPath, head.value + i);
        }
        if (head.left != null) {
            process(head.left, head.value + i);
        }
        if (head.right != null) {
            process(head.right, head.value + i);
        }
    }

    /**
     * @return int
     * @Author 王文
     * @Description 问题二：路径可以从任何节点出发，但必须往下走到任何节点，返回最大路径和 （二叉树递归套路）
     * @Date 2021/8/14
     * @Param [head]
     **/
    public static int getMaxPath3(Node head) {
        Info info = process3(head);
        if (info == null) {
            return 0;
        }
        return info.allTreeMaxSum;
    }

    private static Info process3(Node head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = process3(head.left);
        Info rightInfo = process3(head.right);
        int p1 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p1 = leftInfo.allTreeMaxSum;
        }
        int p2 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p2 = rightInfo.allTreeMaxSum;
        }
        int p3 = head.value;
        int p4 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p4 = rightInfo.formHeadMaxSum + head.value;
        }
        int p5 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p5 = leftInfo.formHeadMaxSum + head.value;
        }
        int allTreeMaxSum = Math.max(Math.max(Math.max(Math.max(p1, p2), p3), p4), p5);
        int formHeadMaxSum = Math.max(Math.max(p4, p5), p5);
        return new Info(allTreeMaxSum, formHeadMaxSum);
    }

    /**
     * @return int
     * @Author 王文
     * @Description 问题三：路径可以从任何节点出发，到任何二节点，返回最大路径和 （二叉树递归套路）
     * @Date 2021/8/14
     * @Param [head]
     **/
    public static int getMaxPath4(Node head) {
        Info info = process4(head);
        if (info == null) {
            return 0;
        }
        return info.allTreeMaxSum;
    }

    private static Info process4(Node head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = process4(head.left);
        Info rightInfo = process4(head.right);
        int p1 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p1 = leftInfo.allTreeMaxSum;
        }
        int p2 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p2 = rightInfo.allTreeMaxSum;
        }
        int p3 = head.value;
        int p4 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p4 = rightInfo.formHeadMaxSum + head.value;
        }
        int p5 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p5 = leftInfo.formHeadMaxSum + head.value;
        }
        int p6 = Integer.MIN_VALUE;
        if (leftInfo != null && rightInfo != null) {
            p6 = rightInfo.formHeadMaxSum + leftInfo.formHeadMaxSum + head.value;
        }
        int allTreeMaxSum = Math.max(Math.max(Math.max(Math.max(Math.max(p1, p6), p2), p3), p4), p5);
        int formHeadMaxSum = Math.max(Math.max(p4, p5), p5);
        return new Info(allTreeMaxSum, formHeadMaxSum);
    }

}
