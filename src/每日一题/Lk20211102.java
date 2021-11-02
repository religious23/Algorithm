package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211102
 * @description: 删除单链表中的某个节点
 * @date 2021-11-02
 */
public class Lk20211102 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode temp = node.next.next;
        node.next.next = null;
        node.next = temp;
    }
}
