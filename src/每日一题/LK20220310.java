package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xc-ww
 * @version : V1.0
 * @className: LK20220310
 * @description: N叉树的前序遍历
 * @date 2022-03-10
 */
public class LK20220310 {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        this.f(root, list);
        return list;
    }

    private void f(Node node, ArrayList<Integer> res) {
        res.add(node.val);
        if (node.children == null) {
            return;
        }
        List<Node> children = node.children;
        children.forEach(s ->
                f(s, res)
        );
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Node> nodes2 = new ArrayList<>();
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes2.add(node5);
        nodes2.add(node6);
        node1.children = nodes;
        node2.children = nodes2;
        LK20220310 lk20220310 = new LK20220310();
        System.out.println(lk20220310.preorder(node1));
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
