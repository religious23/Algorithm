package 常见题目;

import java.util.concurrent.ForkJoinPool;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LCSubsequence
 * @description: 两个字符串的最长公共子序列问题
 * @date 2021-10-20
 */
public class LCSubsequence {
    /**
     * @return int
     * @Author W.Wen
     * @Description 暴力递归版本
     * @Date 2021/10/20
     * @Param [str1, str2]
     **/
    public static int lcs(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        return process(s1, s2, str1.length() - 1, str2.length() - 1);
    }

    private static int process(char[] str1, char[] str2, int i, int j) {
        int res = 0;
        if (i == 0) {
            res = str1[0] == str2[j] ? 1 : res;

        } else if (j == 0) {
            res = str1[j] == str2[0] ? 1 : res;

        } else if (str1[i] == str2[j]) {
            res = process(str1, str2, i - 1, j - 1) + 1;

        } else {
            res = process(str1, str2, i - 1, j);
            res = Math.max(res, process(str1, str2, i, j - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "3fgdrkghfhyty67";
        String str2 = "123fshfjghj67";
        System.out.println(lcs(str1, str2));
        System.out.println(dp(str1, str2));
    }

    /**
     * @return int
     * @Author W.Wen
     * @Description 动态规划版本
     * @Date 2021/10/20
     * @Param [str1, str2]
     **/
    public static int dp(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] dp = new int[str1.length()][str2.length()];
        dp[0][0] = s1[0] == s2[0] ? 1 : 0;
        for (int i = 1; i < str2.length(); i++) {
            dp[0][i] = s1[0] == s2[i] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < str1.length(); i++) {
            dp[i][0] = s1[i] == s2[0] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[str1.length()-1][str2.length()-1];
    }

}
