package morris遍历;

/**
 * @author 王文
 * @version : V1.0
 * @className: Morris
 * @description: Morris遍历
 * @date 2021-05-29
 */
public class Morris {
    public class Node {
        public String value;
        public Node right;
        public Node left;

        public Node() {
        }

        public Node(String value) {
            this.value = value;
        }
    }

    public static void morris(Node head) {
        Node cur = head;
        Node mostRight = null;
        if (head == null) {
            return;
        }
        while (cur != null) {
            if (cur.left != null) {
                mostRight = cur;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            //中序遍历
            System.out.println(cur.value);
            cur = cur.right;
        }
    }
}
