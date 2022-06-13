package 每日一题;

import java.util.concurrent.ForkJoinPool;

/**
 * @author xc-ww
 * @version : V1.0
 * @className: LK20220613
 * @description: 高度检查器
 * @date 2022-06-13
 */
public class LK20220613 {
    public static int heightChecker(int[] heights) {
        int[] ints = new int[101];
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            ints[heights[i]]++;
        }
        for (int i = 0, j = 1; i < heights.length; ) {
            if (ints[j] == 0) {
                j++;
                continue;
            }
            if (heights[i] != j) {
                res++;
            }
            ints[j]--;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,1,4,2,1,3};
        System.out.println(heightChecker(ints));
    }
}
