package 每日一题;

import java.util.List;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211121
 * @description: N叉树的最大深度
 * @date 2021-11-21
 */
public class LK20211121 {
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

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return process(root);
    }

    private int process(Node root) {
        if (root.children.size() == 0) {
            return 1;
        }
        int res = 0;
        for (Node child : root.children) {
            int p = process(child) + 1;
            res = Math.max(res, p);
        }
        return res;
    }
}
