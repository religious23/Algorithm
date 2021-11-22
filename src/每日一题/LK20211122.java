package 每日一题;

import java.util.Random;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211123
 * @description: 打乱数组
 * @date 2021-11-22
 */
public class LK20211122 {
    class Solution {
        private int[] reset;
        private int[] shuffle;

        public Solution(int[] nums) {
            reset = nums;
            shuffle = new int[nums.length];
            System.arraycopy(nums, 0, shuffle, 0, nums.length);
        }

        public int[] reset() {
            return reset;
        }

        public int[] shuffle() {
            Random random1 = new Random();
            for (int i = 0; i < shuffle.length; i++) {
                int random = random1.nextInt(shuffle.length - i) + i;
                swap(i, random);
            }
            return shuffle;
        }

        private void swap(int i, int random) {
            int temp = shuffle[i];
            shuffle[i] = shuffle[random];
            shuffle[random] = temp;
        }
    }
}