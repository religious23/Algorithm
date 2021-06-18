package 数组问题;

/**
 * @author 王文
 * @version : V1.0
 * @className: MaxArrayLength
 * @description: 最大的满足和为某值的最长子数组 数组全为正数
 * @date 2021-06-18
 */

/**
 * 利用数组和单调性 用滑动窗口解决
 */

public class MaxArrayLength {
    public static int getMaxLength(int[] arr, int k) {
        int res = 0;
        int l = 0;
        int r = 0;
        int sum = arr[0];
        while (r < arr.length && l <= r) {
            if (sum == k) {
                res = Math.max(res, r - l + 1);
                r++;
                if (r < arr.length) {
                    sum = sum + arr[r];
                }
            }
            if (sum > k) {
                sum = sum - arr[l];
                l++;
            }
            if (sum < k) {
                r++;
                if (r < arr.length) {
                    sum = sum + arr[r];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {12, 1, 3, 4, 6, 15, 2, 3, 4, 4};
        int k = 13;
        System.out.println(getMaxLength(arr, k));
    }
}
