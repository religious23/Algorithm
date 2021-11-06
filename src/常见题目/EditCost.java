package 常见题目;

import java.util.concurrent.ForkJoinPool;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: EditCost
 * @description: 最短编辑距离
 * @date 2021-11-03
 */
public class EditCost {
    public static int getEditCost(String str1, String str2, int[] arr) {
        int M = str1.length();
        int N = str2.length();
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[0][i] = i * arr[0];
        }
        for (int i = 0; i < M + 1; i++) {
            dp[i][0] = i * arr[1];
        }

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = dp[i - 1][j - 1] + arr[2];
                if (s1[i-1] == s2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + arr[1]);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + arr[0]);
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        int[] arr={1,3,2};
        System.out.println(getEditCost("1", "21324214", arr));
    }
}
