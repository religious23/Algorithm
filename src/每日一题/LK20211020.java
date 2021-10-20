package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211020
 * @description: 最小操作次数使数组元素相等
 * @date 2021-10-20
 */
public class LK20211020 {
    public static int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum-min*nums.length;
    }

    public static void main(String[] args) {
        int[] arr={-1000000000,-1};
        System.out.println(minMoves(arr));
    }
}
