package 常见题目;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: CompleteTreeNodeNumber
 * @description: 求一颗完全二叉树节点数量
 * @date 2021-10-23
 */
public class CompleteTreeNodeNumber {

    public static class Node {
        private Node left;
        private Node right;
        private String value;

        public Node(String value) {
            this.value = value;
        }

        public Node(Node left, Node right, String value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public static int getTreeNumber(Node head) {
        if (head == null) {
            return 0;
        }
        int h = getSize(head);
        return process(head, h);
    }

    private static int process(Node head, int h) {
        if (head.left == null) {
            return 1;
        }
        if (head.right == null) {
            return 2;
        }
        int res;

        if (getSize(head.right) == h - 1) {
            res = process(head.right, h - 1);
            return (int) (Math.pow(2, (h - 1)) + res);
        }
        res = process(head.left, h - 1);
        return (int) (Math.pow(2, (h - 2)) + res);
    }

    private static int getSize(Node head) {
        int h = 1;
        while (head.left != null) {
            h++;
            head = head.left;
        }
        return h;
    }

    public static void main(String[] args) {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");
        Node node8 = new Node("8");
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right=node7;
        node4.left=node8;

        System.out.println(getTreeNumber(node1));
    }
}
