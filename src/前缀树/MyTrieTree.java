package 前缀树;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: MyTrieTree
 * @description: 手撕前缀树
 * @date 2021-04-14
 */
public class MyTrieTree {
    public static class Node {
        public Node[] nexts;

        public Integer pass;

        public Integer end;

        public Node() {
            this.pass = 0;
            this.end = 0;
            nexts = new Node[26];
        }
    }

    public static class Trie {
        public Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] words = word.toCharArray();
            Node node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < words.length; i++) {
                index = words[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] words = word.toCharArray();
                Node node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < words.length; i++) {
                    index = words[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        /*查询word这个字符串之前加过几次*/
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] words = word.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < words.length; i++) {
                index = words[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /*所有加入的字符串中，有几个是以pre这个字符串作为前缀的*/
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] pres = pre.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < pres.length; i++) {
                index = pres[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
