package 常见题目;

/**
 * @author 王文
 * @version : V1.0
 * @className: SnacksWays
 * @description: 背包问题
 * @date 2021-09-25
 */

import java.util.concurrent.ForkJoinPool;

/**
 * 背包容量为W
 * 一共有n袋零食，第i袋零食体积为v[i]>0
 * 总体积不超过背包容量的情况下
 * 一共有多少种零食放法
 */

public class SnacksWays {
    public static int getWays(int w, int[] v) {
        if (w <= 0) {
            return 0;
        }
        if (v == null || v.length < 1) {
            return 0;
        }
        return process(w, v, 0);
    }

    private static int process(int res, int[] v, int index) {
        if (res < 0) {
            return -1;
        }
        if (index == v.length) {
            return 1;
        }
        int p1 = process(res, v, index + 1);
        int p2 = process(res - v[index], v, index + 1);
        return p1 + (Math.max(p2, 0));
    }

    public static int dp(int w, int[] v) {
        if (w <= 0) {
            return 0;
        }
        if (v == null || v.length < 1) {
            return 0;
        }
        int n = v.length;
        int[][] dp = new int[n][w + 1];

        for (int i = 0; i <= w; i++) {
            dp[n - 1][i] = (i >= v[n - 1] ? 2 : 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i + 1][j] + (j - v[i] >= 0 ? dp[i + 1][j - v[i]] : 0);
            }
        }
        return dp[0][w];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        int w = 4;
        System.out.println(getWays(w, arr));
        System.out.println(dp(w, arr));
    }
}
