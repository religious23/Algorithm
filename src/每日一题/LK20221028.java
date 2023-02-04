package 每日一题;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * @author xc-ww
 * @version : V1.0
 * @className: LK20221028
 * @description: 子数组的最小值之和
 * @date 2022-10-28
 */
public class LK20221028 {
    public static int sumSubarrayMins(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                res += min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(sdf.format(1670549277000L));

        int[] arr={3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
}
