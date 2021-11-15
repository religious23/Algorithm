package 每日一题;


import java.util.HashMap;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211114
 * @description: 键值映射
 * @date 2021-11-14
 */
public class LK20211114 {
    public class MapSum {

        private Node root;
        private HashMap<String, Integer> map;

        public MapSum() {
            root = new Node();
            map = new HashMap<String, Integer>();
        }

        public void insert(String key, int val) {
            if (map.containsKey(key)) {
                map.put(key, val);
                val = val - map.get(key);
            }else {
                map.put(key, val);
            }
            char[] chs = key.toCharArray();
            Node node = root;
            int index;
            for (char ch : chs) {
                index = ch - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new Node();
                }
                node = node.next[index];
                node.pass += val;
            }
        }

        public int sum(String prefix) {
            char[] chars = prefix.toCharArray();
            Node node = root;
            int index;
            for (char aChar : chars) {
                index = aChar - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.pass;
        }
    }

    class Node {
        private int pass;
        private Node[] next;

        public Node() {
            pass = 0;
            next = new Node[26];
        }
    }
}
