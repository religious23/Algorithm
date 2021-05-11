package 数列的递归;

/**
 * @author 王文
 * @version : V1.0
 * @className: FibonacciProblem
 * @description: 斐波那契数列
 * @date 2021-05-10
 */
public class FibonacciProblem {
    public static int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n-2)+f1(n-1);
    }
}
