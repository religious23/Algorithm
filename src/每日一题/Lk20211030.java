package 每日一题;


import java.util.Arrays;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211030
 * @description: 只出现一次的数字
 * @date 2021-10-30
 */
public class Lk20211030 {
    public static int[] singleNumber(int[] nums) {
        int res = 0;
        int a = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        for (int num : nums) {
            if (((((~res) + 1) & res) & num) == 0) {
                a = a ^ num;
            }
        }
        int b = a ^ res;
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2, 5, 5};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }
}
