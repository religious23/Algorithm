package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210527
 * @description: 汉明距离
 * @date 2021-05-27
 */
public class LK20210527 {
    public static int hanming(long a, long b) {
        int res=0;
        for (int i = 0; a >> i != 0 || b >> i != 0; i++) {
            if ((a >> i) % 2 != (b >> i) % 2) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long a=4;
        long b=10;
        System.out.println(hanming(a, b));
    }
}
