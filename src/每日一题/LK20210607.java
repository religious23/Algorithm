package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210607
 * @description: 目标和 （动态规划） 转成背包问题（没弄，弄了暴力递归和记忆化搜索）
 * @date 2021-06-07
 */

import java.util.HashMap;

/**
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 */

public class LK20210607 {
    public static int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        return process(nums, 0, target, 0, map);
    }

    private static int process(int[] nums, int i, int target, int addres, HashMap<String, Integer> map) {
        if (i == nums.length) {
            return addres == target ? 1 : 0;
        }
        int p1;
        int p2;
        if (map.containsKey((i + 1) + "+" + (addres - nums[i]))) {
            p1 = map.get((i + 1) + "+" + (addres - nums[i]));
        } else {
            p1 = process(nums, i + 1, target, addres - nums[i], map);
            map.put((i + 1) + "+" + (addres - nums[i]), p1);
        }
        if (map.containsKey((i + 1) + "+" + (addres + nums[i]))) {
            p2 = map.get((i + 1) + "+" + (addres + nums[i]));
        } else {
            p2 = process(nums, i + 1, target, addres + nums[i], map);
            map.put((i + 1) + "+" + (addres + nums[i]), p2);
        }
        return p1 + p2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(arr, target));
    }

}
