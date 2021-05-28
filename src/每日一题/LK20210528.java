package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210528
 * @description: 汉明距离总和
 * @date 2021-05-28
 */
public class LK20210528 {
    public static int hanmingSum(int[] arr) {
        int max = getMax(arr);
        int res = 0;
        for (int i = 0; max >> i != 0; i++) {
            int a = 0;
            for (int j = 0; j < arr.length; j++) {
                a += (arr[j] >> i) & 1;
            }
            res += a * (arr.length - a);
        }
        return res;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 14, 2};
        System.out.println(hanmingSum(arr));
    }
}
