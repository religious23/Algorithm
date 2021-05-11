package 暴力递归;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: NQueens
 * @description: N皇后问题
 * @date 2021-03-28
 */

/**
 * 任何两个皇后一定不共线，不共列，不共斜线
 */
public class NQueens {
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    public static int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    //record[0..i-1]你需要看，record[i...]不需要看
    //返回i行皇后，放在了j列，是否有效
    //不用判断行，只需判断列和斜线
    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    //n皇后问题的优化版实现
    //时间复杂度不变，加快了常量时间
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        //如果你是八皇后问题，limit最后有8个1，其他都是0
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    //colLim 列的限制，1的位置不能放皇后，0的位置可以
    //leftDiaLim 左斜线的限制，1的位置不能放皇后，0的位置可以
    //rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        //所有候选皇后的位置，都在pos上
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            //提取出pos中，最右侧的1来，剩下位置都是0
            mostRightOne = pos & (~pos + 1);

            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 15;
        long start2 = System.currentTimeMillis();
        int numbers2 = num2(num);
        long end2 = System.currentTimeMillis();
        System.out.println("方法2：所用时间："+(end2-start2));
        System.out.println("方法2："+num + "皇后问题的解的个数有：" + numbers2 + "个");
        long start1 = System.currentTimeMillis();
        int numbers1 = num1(num);
        long end1 = System.currentTimeMillis();
        System.out.println("方法1：所用时间："+(end1-start1));
        System.out.println("方法2："+num + "皇后问题的解的个数有：" + numbers1 + "个");
    }
}
