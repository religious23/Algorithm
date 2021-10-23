package 常见题目;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: BSTtoDoubleBigLInkedList
 * @description: 二叉树转成双向链表 (中序遍历的顺序)
 * @date 2021-10-22
 */
public class BSTtoDoubleBigLInkedList {

    public static class Node {
        private Node right;
        private Node left;
        private String value;
    }

    public static class Info {
        private Node next;
        private Node end;

        public Info(Node next, Node end) {
            this.next = next;
            this.end = end;
        }
    }

    public static Node getList(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).next;
    }

    private static Info process(Node head) {
        if (head == null) {
            return new Info(null, null);
        }
        Info next = process(head.left);
        Info end = process(head.right);
        if (next.end != null) {
            next.end.right = head;
        }
        head.left = next.end;
        if (end.next != null) {
            end.next.left = head;
        }
        head.right = end.next;
        return new Info(
                next.next != null ? next.next : head,
                end.end != null ? end.end : head
        );
    }
}
