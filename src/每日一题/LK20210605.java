package 每日一题;


/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210605
 * @description: 移除链表元素
 * @date 2021-06-05
 */
public class LK20210605 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node removeLinkedValue(Node head, int value) {
        Node node = new Node(0);
        node.next = head;
        Node cur = node;
        while (cur.next != null) {
            if (cur.next.value == value) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        Node node = removeLinkedValue(node1, 3);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
