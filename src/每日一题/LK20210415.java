package 每日一题;

/**
 * 你是一个专业的小偷，
 * 计划偷窃沿街的房屋，
 * 每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
 */

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210415
 * @description:
 * @date 2021-04-15
 */


// TODO: 2021/4/15 明天转成动态规划 给自己个👍
public class LK20210415 {
    public static int getMax(int[] arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        if (arr.length <= 3) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                max = Math.max(arr[i], max);
            }
            return max;
        }
        int L = arr.length - 1;
        //第一个选了的情况
        int m1 = process(arr, 2, L - 1) + arr[0];
        //第一个没有选的情况
        int m2 = process(arr, 1, L);
        return Math.max(m1, m2);
    }

    private static int process(int[] arr, int i, int L) {
        if (i == L) {
            return arr[i];
        }
        int p1 = arr[i];
        if (i + 2 <= L) {
            p1 = arr[i] + process(arr, i + 2, L);
        }
        int p2 = process(arr, i + 1, L);
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1};
        System.out.println(getMax2(arr));
    }


    public static int[] getDp(int[] arr) {
        int L = arr.length;
        int[] dp = new int[L];
        dp[L - 1] = arr[L - 1];
        for (int i = L - 2; i >= 0; i--) {
            if (i + 2 <= L - 1) {
                dp[i] = Math.max(dp[i + 2] + arr[i], dp[i + 1]);
            } else {
                dp[i] = Math.max(arr[i], dp[i + 1]);
            }
        }
        return dp;
    }


    public static int getMax2(int[] arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        if (arr.length <= 3) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                max = Math.max(arr[i], max);
            }
            return max;
        }

        int[] arr1 = new int[arr.length - 3];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i + 2];
        }

        int[] arr2 = new int[arr.length - 1];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i + 1];
        }

        int[] dp1 = getDp(arr1);
        int[] dp2 = getDp(arr2);
        int m1 = arr[0] + dp1[0];
        int m2 = dp2[0];
        return Math.max(m1, m2);

    }
}
