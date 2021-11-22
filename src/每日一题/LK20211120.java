package 每日一题;

import java.util.Arrays;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211120
 * @description: 最长和谐子序列
 * @date 2021-11-20
 */
public class LK20211120 {
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int L = 0;
        int R = 0;
        while (R < nums.length) {
            if (nums[R] == nums[L]) {
                R++;
            } else if (nums[R] - nums[L] == 1) {
                R++;
                res = Math.max(res, R - L);
            } else {
                L++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        System.out.println(findLHS(arr));
    }
}
