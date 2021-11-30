package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211130
 * @description: 第N位数字
 * @date 2021-11-30
 */
public class LK20211130 {
    public int findNthDigit(int n) {
        int s = 0;
        int i = 0;
        int[] ints = new int[32];
        for (; s < n; ) {
            ints[i] = s;
            s += 9 * Math.pow(10, i) * (i + 1);
            i++;
        }
        int num = (int) (Math.pow(10, i - 1) + ((n - ints[i - 1] - 1) / (i)));
        int index = (n - ints[i - 1] - 1) % (i);
        return Integer.parseInt(String.valueOf((num+"").toCharArray()[index]));
    }

    public static void main(String[] args) {
        LK20211130 lk20211130 = new LK20211130();
        System.out.println(lk20211130.findNthDigit(193));
    }
}
