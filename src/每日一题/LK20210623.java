package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210623
 * @description: 二进制中1的个数
 * @date 2021-06-23
 */

/**
 * 把一个整数减去1，再和原整数做与运算，
 * 会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，
 * 就可以进行多少次这样的操作。
 */
public class LK20210623 {
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(9));
    }
}
