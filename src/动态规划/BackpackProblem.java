package 动态规划;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: BackpackProblem
 * @description: 背包问题  动态规划版本
 * @date 2021-03-30
 */
public class BackpackProblem {
    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }


    //暴力递归版本
    private static int process(int[] w, int[] v, int i, int res) {
        if (res < 0) {
            return -1;
        }
        if (i == w.length) {
            return 0;
        }
        int p1 = process(w, v, i + 1, res);
        int p2 = -1;
        int p2Next = process(w, v, i + 1, res - w[i]);
        if (p2Next != -1) {
            p2 = v[i] + p2Next;
        }
        return Math.max(p1, p2);
    }


    private static int dpWay(int[] w, int[] v, int bag) {
        int[][] ints = new int[w.length + 1][bag + 1];
        for (int i = w.length - 1; i >= 0; i--) {
            for (int j = 0; j < bag + 1; j++) {
                int p1 = ints[i + 1][j];
                int p2 = -1;
                if (j - w[i] >= 0) {
                    p2 = ints[i + 1][j - w[i]];
                }
                if (p2 != -1) {
                    p2 = v[i] + p2;
                }
                ints[i][j] = Math.max(p1, p2);
            }
        }
        return ints[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(getMaxValue(weights, values, bag));
        System.out.println(dpWay(weights, values, bag));
    }
}
