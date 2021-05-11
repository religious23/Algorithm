package 数列的递归;

/**
 * @author 王文
 * @version : V1.0
 * @className: FibonacciProblem
 * @description: 斐波那契数列
 * @date 2021-05-10
 */
public class FibonacciProblem {

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        System.out.println(f1(47));
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        long l3 = System.currentTimeMillis();
        System.out.println(f2(47));
        long l4 = System.currentTimeMillis();
        System.out.println(l4 - l3);
    }

    /**
     * @return int
     * @Author 王文
     * @Description 暴力
     * @Date 2021/5/11
     * @Param [n]
     **/
    public static int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 2) + f1(n - 1);
    }

    /**
     * @return null
     * @Author 王文
     * @Description 动态规划版本
     * @Date 2021/5/11
     * @Param
     **/
    public static int f2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * @return int
     * @Author 王文
     * @Description 矩阵乘法版本
     * @Date 2021/5/11
     * @Param [n]
     **/
    public static int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {
                {1, 1},
                {1, 0}
        };
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        } //res=矩阵中的1
            int[][] tmp = m;
            for (; p != 0; p >>= 1) {
                if ((p & 1) != 0) {
                    res = muliMatrix(res, tmp);
                }
                tmp = muliMatrix(tmp, tmp);
            }
        return res;
    }

    private static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
