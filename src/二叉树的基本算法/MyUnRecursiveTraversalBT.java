package 二叉树的基本算法;

import java.util.Stack;

/**
 * @ClassName: MyUnRecursiveTraversalBT
 * @Description: 自己写的非递归方式实现二叉树的遍历
 * @Author W.Wen
 * @Date 2021-01-29
 * @Version : V1.0
 */
public class MyUnRecursiveTraversalBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void xianXu(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null) {
                    stack.add(head.right);
                }
                if (head.left != null) {
                    stack.add(head.left);
                }
            }
        }
    }

    public static void zhongXu(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.add(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void xianXu1(Node head) {
        if (head != null) {
            Stack<Node> nodes = new Stack<>();
            nodes.add(head);
            while (!nodes.isEmpty()) {
                head = nodes.pop();
                System.out.println(head);
                if (head.right != null) {
                    head = head.right;
                }
                if (head.left != null) {
                    head = head.left;
                }
            }
        }
    }

    public static void zhongXu1(Node head) {
        if (head != null) {
            Stack<Node> nodes = new Stack<>();
            while (!nodes.isEmpty() || head != null) {
                if (head != null) {
                    nodes.add(head);
                   head=head.left;
                }
                else{
                    head=nodes.pop();
                    System.out.println(head.left);
                    head=head.right;
                }
            }
        }
    }
}
