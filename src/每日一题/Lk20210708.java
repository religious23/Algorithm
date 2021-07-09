package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: Lk20210708
 * @description: 数组问题
 * @date 2021-07-08
 */

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 */
public class Lk20210708 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0};
        int k = 0;
        System.out.println(numSubarraysWithSum(arr, k));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int Pi_lo = 0, Pi_hi = 0;
        int sum_lo = 0, sum_hi = 0;
        int res = 0;

        for (int j = 0; j < nums.length; j++) {   //固定窗口的终点
            sum_lo += nums[j];//计算以Pi_lo为起点以当前点为终点的窗口的和
            while (Pi_lo < j && sum_lo > goal) {
                sum_lo -= nums[Pi_lo++];//此时Pi_lo右移 - 只要移到第一个满足条件的位置即可 - 此时Pi_lo就是以j为终点的满足条件的窗口的最左边界
            }

            sum_hi += nums[j];//计算以Pi_hi为起点以当前点为终点的窗口的和

            //1.窗口和大于S了，此时指针右移动 - 直到窗口和小于等于S
            //2.窗口和等于S，但是当前指针所指向元素是0，不影响sum_hi的值，指针右移动，直到遇到1为止
            while (Pi_hi < j && (sum_hi > goal || (sum_hi == goal && nums[Pi_hi] == 0))) {
                sum_hi -= nums[Pi_hi++];
            }

            //对于固定的j，以j为终点的满足条件的窗口的数目就是Pi_hi和Pi_lo的距离
            if (sum_hi == goal) {//这里的判断条件可以sum_hi == S也可以是sum_lo ==S
                res += Pi_hi - Pi_lo + 1;
            }
        }
        return res;
    }
}
