package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211104
 * @description: 有效的完全平方数
 * @date 2021-11-04
 */
public class Lk20211104 {
    public static boolean isPerfectSquare(int num) {
        boolean res = false;
        int L = 0;
        int R = num;
        while (R >= L) {
            int mid = (R - L) / 2 + L;
            long sqrM=(long) mid * mid;
            if (sqrM == num) {
                res = true;
                break;
            }
            if (sqrM < num) {
                L = mid + 1;
            }
            else{
                R = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        System.out.println(isPerfectSquare(a));
    }
}
