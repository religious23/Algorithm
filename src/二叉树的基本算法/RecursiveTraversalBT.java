package 二叉树的基本算法;

/**
 * @ClassName: RecursiveTraversalBT
 * @Description: 递归遍历二叉树
 * @Author W.Wen
 * @Date 2021-01-27
 * @Version : V1.0
 */
public class RecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //二叉树的递归遍历
    public static void f(Node head) {
        if (head == null) {
            return;
        }
        //1 (先序）
        f(head.left);
        //2 (中序)
        f(head.right);
        //3 (后序)
    }

    // 先序打印所有节点
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    //中序打印所有节点
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    //后序打印所有节点
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

    // for test
    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        head.left.right=new Node(5);
        head.right.left=new Node(6);
        head.right.right=new Node(7);

        pre(head);
        System.out.println("============");
        in(head);
        System.out.println("=============");
        pos(head);
        System.out.println("==============");
    }

    public static void process(Node X){
        if(X==null){
            return;
        }
        process(X.left);
        process(X.right);
    }
}
