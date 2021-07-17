package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210716
 * @description: 统计一个数字在排序数组中出现的次数。
 * @date 2021-07-16
 */
public class LK20210716 {
    public static int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) >>1;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 5, 5, 7, 8, 9};
        int target = 6;
        System.out.println(search(arr, target));
    }
}
