package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211007
 * @description: 范围求和II
 * @date 2021-11-07
 */
public class LK20211007 {
    public static int maxCount(int m, int n, int[][] ops) {
        int res1 = m;
        int res2 = n;
        for (int[] op : ops) {
            res1 = Math.min(res1, op[0]);
            res2 = Math.min(res2, op[1]);
        }
        return res1 * res2;
    }


    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] operations = {{2, 2}, {3, 3}};
        System.out.println(maxCount(m, n, operations));
    }
}
