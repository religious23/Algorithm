package 动态规划;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: TwoPlayerCardProblem
 * @description: 双人纸牌问题  范围上尝试的模型 动态规划版本
 * @date 2021-03-28
 */


/**
 * 给定一个整数数组arr，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌
 * 规定玩家A先拿，玩家B后拿
 * 但是每个玩家只能拿走最左或最右的纸牌
 * 玩家A和玩家B都绝顶聪明，请返回最后获胜者的分数
 */
public class TwoPlayerCardProblem {
    public static String getWin(int[] arr) {
        if (arr == null) {
            return "没有牌，无法游戏！";
        }
        if (arr.length == 1) {
            return "只有一张牌，先手玩家赢，得分为：" + arr[0];
        }
        int f = f(arr, 0, arr.length - 1);
        int l = l(arr, 0, arr.length - 1);
        String winner = f > l ? "先手玩家赢，分数为：" + f : "后手玩家赢，分数为：" + l;
        return winner;
    }

    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int l1 = l(arr, L + 1, R);
        int l2 = l(arr, L, R - 1);
        return Math.max(l1 + arr[L], l2 + arr[R]);
    }

    public static int l(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int f1 = f(arr, L + 1, R);
        int f2 = f(arr, L, R - 1);
        return Math.min(f1, f2);
    }

    public static int dpWay(int[] arr) {

        if (arr == null) {
            System.out.println("没有牌，无法游戏！");
            return 0;
        }
        if (arr.length == 1) {
            System.out.println("只有一张牌，先手玩家赢，得分为：" + arr[0]);
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] l = new int[N][N];
        for (int i = 0; i <= N - 1; i++) {
            f[i][i] = arr[i];
            l[i][i] = 0;
        }
        /*if (L == R) {
            return arr[L];
        }*/
        for (int i = 1; i < N; i++) {
            int row = 0;
            int col = i;
            while (row < N && col < N) {
                f[row][col] = Math.max(l[row + 1][col] + arr[row], l[row][col - 1] + arr[col]);
                l[row][col] = Math.min(f[row + 1][col], f[row][col - 1]);
                row++;
                col++;
            }
        }
        return Math.max(f[0][N - 1], l[0][N - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {2, 41, 1, 51, 7, 8, 9, 8, 0, 24, 252, 14, 1, 23, 12, 56, 9, 8, 4, 3, 7, 6, 2};
        long l1 = System.currentTimeMillis();
        String win = getWin(arr);
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        long l3 = System.currentTimeMillis();
        int win2 = dpWay(arr);
        long l4 = System.currentTimeMillis();
        System.out.println(l4 - l3);
        System.out.println(win);
        System.out.println(win2);

    }
}
