package 常见题目;

import java.util.Date;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: SubArrayMaxSum
 * @description: 给定一个数组，求子数组的最大累加和 (两个变量搞定) 加大难度（二维的）
 * @date 2021-10-21
 */
public class SubArrayMaxSum {
    public static int getMaxSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            cur += i;
            max = Math.max(max, cur);
            cur = Math.max(cur, 0);
        }
        return max;
    }


    public static int getMaxSumTwo(int[][] arr) {
        int M = arr.length;
        int N = arr[0].length;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            int[] ints = new int[N];
            for (int j = i; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    ints[k]+=arr[j][k];
                }
                int maxSum = getMaxSum(ints);
                max=Math.max(maxSum,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -3, -5, -1, -2, -5};
        int[][] arrTwo={{1,2,3},{4,-5,6},{-2,-1,19}};
        System.out.println(getMaxSumTwo(arrTwo));
        System.out.println(getMaxSum(arr));
    }
}
