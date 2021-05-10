package 动态规划;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: CoinsWay
 * @description: 拼凑钱的问题
 * @date 2021-04-01
 */
public class CoinsWay {

    //arr中都是正数且重复值，返回组成的aim的方法数
    public static int ways1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    //可以自由使用arr[index...]所有的面值，每一种面值都可以使用任意张
    //组成aim有多少种方法
    private static int process1(int[] arr, int i, int aim) {

        if (i == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[i] <= aim; zhang++) {
            ways += process1(arr, i + 1, aim - zhang * arr[i]);
        }
        return ways;
    }


    public static int ways2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int i, int aim, int[][] dp) {
        if (dp[i][aim] != -1) {
            return dp[i][aim];
        }
        if (i == arr.length) {
            dp[i][aim] = aim == 0 ? 1 : 0;
            return dp[i][aim];
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[i] <= aim; zhang++) {
            ways += process2(arr, i + 1, aim - zhang * arr[i], dp);
        }
        dp[i][aim] = ways;
        return dp[i][aim];
    }

    public static int ways3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[N][0] = 1;
        for (int i = arr.length-1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[i] <= rest; zhang++) {
                    ways += dp[i + 1][rest - zhang * arr[i]];
                }
                dp[i][rest] = ways;
            }
        }
        return dp[0][aim];
    }


    public static int ways4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[N][0] = 1;
        for (int i = arr.length-1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                /* int ways = 0;*/
               /* for (int zhang = 0; zhang * arr[i] <= rest; zhang++) {
                    ways = dp[i + 1][aim - zhang * arr[i]];
                }*/
                dp[i][rest] = dp[i + 1][rest];
                if (rest - arr[i] >= 0) {
                    dp[i][rest] += dp[i][rest-arr[i]];
                }
            }
        }
        return dp[0][aim];
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 100};
        int aim = 2400;
        long l1 = System.currentTimeMillis();
        System.out.println(ways1(arr, aim));
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        long l3 = System.currentTimeMillis();
        System.out.println(ways2(arr, aim));
        long l4 = System.currentTimeMillis();
        System.out.println(l4 - l3);
        long l5 = System.currentTimeMillis();
        System.out.println(ways3(arr, aim));
        long l6 = System.currentTimeMillis();
        System.out.println(l6 - l5);
        long l7 = System.currentTimeMillis();
        System.out.println(ways4(arr, aim));
        long l8 = System.currentTimeMillis();
        System.out.println(l8 - l7);
    }
}