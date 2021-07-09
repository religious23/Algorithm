package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210709
 * @description: 摩尔投票
 * @date 2021-07-09
 */
public class LK20210709 {
    public static int majorityElement(int[] nums) {
        int mole = 0;
        int[] dp = new int[1];
        for (int num : nums) {
            if (mole == 0) {
                dp[0] = num;
                mole++;
                continue;
            }
            if (num != dp[0]) {
                mole--;
                continue;
            }
            mole++;
        }
        boolean falg = decide(nums, dp[0]);
        return falg ? dp[0] : -1;
    }

    private static boolean decide(int[] nums, int i) {
        int sum = 0;
        for (int num : nums) {
            if (num == i) {
                sum++;
            }
        }
        return sum > nums.length >> 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 2};
        System.out.println(majorityElement(arr));
    }
}
