package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211129
 * @description: 第K个最小的素数分数
 * @date 2021-11-29
 */
public class LK20211129 {

    public class Node {
        private String k;
        private Double v;

        public Node(String k, Double v) {
            this.k = k;
            this.v = v;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.v > o2.v) {
                    return 1;
                }
                return -1;
            }
        });
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Node node = new Node(arr[i] + ":" + arr[j], (double) arr[i] / (double) arr[j]);
                priorityQueue.add(node);
                if (priorityQueue.size() > (arr.length * (arr.length - 1)) / 2 - k + 1) {
                    priorityQueue.poll();
                }
            }
        }
        Node poll = priorityQueue.peek();
        assert poll != null;
        String k1 = poll.k;
        return Arrays.stream(k1.split(":")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1,7};
        int k = 1;
        LK20211129 lk20211129 = new LK20211129();
        System.out.println(Arrays.toString(lk20211129.kthSmallestPrimeFraction(arr, k)));
    }
}
