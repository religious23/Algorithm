package 动态规划;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: RobotWalk
 * @description: 左走右走问题  从暴力递归到动态规划
 * @date 2021-03-29
 */
public class RobotWalk {
    public static int w1(int n, int res, int i, int m) {
        if (n < 2 || i < 1 || res < 1 || m < 1 || i > m) {
            return 0;
        }
        return walk1(n, res, i, m);

    }

    public static int w2(int n, int res, int i, int m) {
        if (n < 2 || i < 1 || res < 1 || m < 1 || i > m) {
            return 0;
        }
        int[][] ints = new int[m + 1][res + 1];
        for (int k = 0; k < m + 1; k++) {
            for (int j = 0; j < res + 1; j++) {
                ints[k][j]=-1;
            }
        }
        return walk2(n, res, i, m, ints);

    }

    private static int walk2(int n, int res, int i, int m, int[][] ints) {

        if (ints[i][res] != -1) {
            return ints[i][res];
        }

        if (res == 0) {
            ints[i][0] = i == n ? 1 : 0;
            return ints[i][0];
        }
        if (i == 1) {
            ints[i][res] = walk2(n, res - 1, i + 1, m, ints);
            return ints[i][res];
        }
        if (i == m) {
            ints[i][res] = walk2(n, res - 1, i - 1, m, ints);
            return ints[i][res];
        }

        ints[i][res] = walk2(n, res - 1, i + 1, m, ints) + walk2(n, res - 1, i - 1, m, ints);
        return ints[i][res];
    }


    private static int walk1(int n, int res, int i, int m) {
        if (res == 0) {
            return n == i ? 1 : 0;
        }
        if (i == 1) {
            return walk1(n, res - 1, i + 1, m);
        }
        if (i == m) {
            return walk1(n, res - 1, i - 1, m);
        }
        return walk1(n, res - 1, i + 1, m) + walk1(n, res - 1, i - 1, m);
    }

    public static void main(String[] args) {

        long begin1 = System.currentTimeMillis();
        int i = w1(3, 35, 2, 6);
        long end1 = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(end1 - begin1);
        long begin2 = System.currentTimeMillis();
        int j = w2(3, 201, 2, 6);
        long end2 = System.currentTimeMillis();
        System.out.println(j);
        System.out.println(end2 - begin2);
    }
}
