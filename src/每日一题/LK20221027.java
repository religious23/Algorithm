package 每日一题;

/**
 * @author xc-ww
 * @version : V1.0
 * @className: LK20221027
 * @description: 数组元素积的符号
 * @date 2022-10-27
 */
public class LK20221027 {
    public static int arraySign(int[] nums) {
        if (nums.length == 0) return 0;
        boolean res = true;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) res=!res;
        }
        return res ? 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println(arraySign(nums));
    }
}
