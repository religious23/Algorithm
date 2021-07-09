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
        int moore = 0;
        int temp=0;
        for (int num : nums) {
            if (moore == 0) {
                temp = num;
                moore++;
                continue;
            }
            if (num != temp) {
                moore--;
                continue;
            }
            moore++;
        }
        boolean falg = decide(nums, temp);
        return falg ? temp : -1;
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
