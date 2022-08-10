package 二叉树的递归;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: RandomBST
 * @description: 二叉树的递归实现二叉树寻找最大搜素子树
 * @date 2021-01-23
 */
public class RandomBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //任何子树
    public static class Info {
        public boolean isAllBST;//是否是搜素树
        public int maxSubBSTSize;//最大搜素树长度
        public int min;
        public int max;

        public Info(boolean is, int size, int mi, int ma) {
            isAllBST = is;
            maxSubBSTSize = size;
            min = mi;
            max = ma;
        }
    }

    public static Info process(Node X) {
        if (X == null) {
            return null;
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        int min = X.value;
        int max = X.value;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }


        boolean isAllBST=false;//是否是搜素树
        int maxSubBSTSize = 0;//最大搜素树长度
        if (leftInfo != null) {
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }

        if (
            //1.左树整体需要是整体二叉树
                (leftInfo == null ? true : leftInfo.isAllBST)
                        &&
                        (rightInfo == null ? true : rightInfo.isAllBST)
                        &&
                        //左树最大值<x
                        (leftInfo == null ? true : leftInfo.max < X.value)
                        &&
                        (rightInfo == null ? true : rightInfo.min > X.value)
        ) {
            maxSubBSTSize=leftInfo.maxSubBSTSize+rightInfo.maxSubBSTSize+1;
            isAllBST = true;
        }

        return new Info(isAllBST, maxSubBSTSize, max, min);

    }

}
