package 动态规划;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Coffee
 * @description: 洗咖啡最短时间
 * @date 2021-04-04
 */
public class Coffee {
    public static int minTime(int[] arr, int a, int b) {
        if (a >= b) {
            return arr[arr.length - 1] + b;
        }
        return process(arr, a, b, 0, 0);
    }

    private static int process(int[] drinks, int a, int b, int index, int washLine) {
        //只剩下最后一杯咖啡
        if (index == drinks.length - 1) {
            return Math.min(Math.max(washLine, drinks[index]) + a, drinks[index] + b);
        }
        //剩下的不止一杯咖啡
        //wash 是我当前的咖啡机，洗完的时间
        int wash = Math.max(washLine, drinks[index]) + a;
        //index+1 ...变干净的最早时间
        int next1 = process(drinks, a, b, index + 1, wash);

        //index....
        int p1 = Math.max(wash, next1);
        int dry = drinks[index] + b;//挥发，index一杯，结束的时间点
        int next2 = process(drinks, a, b, index + 1, washLine);
        int p2 = Math.max(dry, next2);
        return Math.min(p1, p2);
    }

    public static int dp(int[] drinks, int a, int b) {
        if (a >= b) {
            return drinks[drinks.length - 1] + b;
        }
        int N = drinks.length;
        int limit = 0; //咖啡机什么时候可用
        for (int i = 0; i < N; i++) {
            limit = Math.max(limit, drinks[i]) + a;
        }
        int[][] dp = new int[N][limit + 1];
        for (int washLine = 0; washLine <= limit; washLine++) {
            dp[N - 1][washLine] = Math.min(Math.max(washLine, drinks[N - 1]) + a, drinks[N - 1] + b);
        }

        for (int index = N - 2; index >= 0; index--) {
            for (int washLine = 0; washLine <= limit; washLine++) {
                int wash = Math.max(washLine, drinks[index]) + a;
                int p1 = Integer.MAX_VALUE;
                if (wash <= limit) {
                    p1 = Math.max(wash, dp[index + 1][wash]);
                }
                int p2 = Math.max(drinks[index] + b, dp[index + 1][washLine]);

                dp[index][washLine] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 5, 5, 7, 10, 12, 12, 12, 13, 13, 13, 21};
        int a = 3;
        int b = 10;
        System.out.println(minTime(arr, a, b));
        System.out.println(dp(arr, a, b));
    }
}
