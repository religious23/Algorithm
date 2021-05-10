package 动态规划;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: FSequence
 * @description: 斐波那契数列
 * @date 2021-03-29
 */
public class FSequence {
    //动态规划版本 速度太快了
    public static int f1(int n) {
        int[] ints = new int[n + 1];
        if (ints[n] != 0) {
            return ints[n];
        }
        return ff(n, ints);
    }

    public static int ff(int n, int[] ints) {
        if (ints[n] != 0) {
            return ints[n];
        }

        if (n == 1) {
            ints[n] = 1;
            return ints[n];
        }
        if (n == 2) {
            ints[n] = 2;
            return 2;
        }
        ints[n] =ff(n - 1, ints) + ff(n - 2, ints);
        return ints[n];
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(f1(200));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    //暴力递归版本
    public static int f2(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        return f2(n-1)+f2(n-2);
    }
}
