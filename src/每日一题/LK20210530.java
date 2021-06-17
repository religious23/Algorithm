package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210530
 * @description: 判断2的幂次方
 * @date 2021-06-07
 */
public class LK20210530 {
    public static boolean isPowerOfTwo(int n) {

        return n <= 0 ? false : ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(5));
    }
}
