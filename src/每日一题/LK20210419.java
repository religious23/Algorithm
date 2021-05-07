package 每日一题;

import java.util.Arrays;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210419
 * @description: 不利用额外空间 实现数组去重
 * @date 2021-04-19
 */
public class LK20210419 {
    public static int getArray(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int p = 0;
        int q = arr.length - 1;
        while (q>-1&&arr[q] == value) {
            q--;
        }
        while (p < q) {
            if (arr[p] == value) {
                arr[p] = arr[q--];
            }
            p++;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int array = getArray(arr, 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(array);
    }
}
