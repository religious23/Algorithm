package 常见题目;

import java.util.*;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: TopKTimes
 * @description: 出现次数前k次的字符串
 * @date 2021-10-19
 */
public class TopKTimes {

    public static class Node {
        private String val;
        private int time;

        public Node(String val, int time) {
            this.val = val;
            this.time = time;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    public static String[] getTopKString(String[] arr, int k) {
        if (arr.length < 2) {
            return arr;
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.time - o2.time;
            }
        });
        HashMap map = new HashMap<String, Node>();
        for (String s : arr) {
            if (map.containsKey(s)) {
                Node o = (Node) map.get(s);
                o.setTime(o.getTime() + 1);
                map.put(s, o);
            }
            map.put(s, new Node(s, 1));
        }

        Set<String> set = map.keySet();
        for (String o : set) {
            Node o1 = (Node) map.get(o);
            if (priorityQueue.size() < k) {
                priorityQueue.add(o1);
            } else {
                priorityQueue.add(o1);
                priorityQueue.poll();
            }
        }
        String[] strings = new String[k];
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            strings[i] = priorityQueue.poll().val;
        }
        return strings;
    }

    public static void main(String[] args) {
        String[] arr = {"1"};
        System.out.println(Arrays.toString(getTopKString(arr, 2)));
    }
}
