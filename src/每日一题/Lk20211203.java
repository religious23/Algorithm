package 每日一题;

import java.util.PriorityQueue;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211203
 * @description: K次取反后最大化的数组和
 * @date 2021-12-03
 */
public class Lk20211203 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        int res = 0;
        for (int num : nums) {
            integers.add(num);
            res += num;
        }
        for (int i = 0; i < k; i++) {
            Integer poll = integers.poll();
            if (poll >= 0) {
                if ((k - i) % 2 != 0) {
                    res -= (2 * poll);
                }
                break;
            }
            integers.add(-poll);
            res -= (2 * poll);
        }
        return res;
    }

    public static void main(String[] args) {
        Lk20211203 lk20211203 = new Lk20211203();
        System.out.println(lk20211203.largestSumAfterKNegations(new int[]{4,2,3}, 1));
    }
}
