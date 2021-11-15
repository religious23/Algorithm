package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211110
 * @description: 提莫攻击
 * @date 2021-11-15
 */
public class LK20211110 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int start = timeSeries[0];
        int res = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i > 0 && (timeSeries[i] - timeSeries[i - 1]) > duration) {
                res += timeSeries[i - 1] + duration - start;
                start = timeSeries[i];
            }
        }
        res += ( timeSeries[timeSeries.length - 1] + duration - start);
        return res;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1,2};
        int duration = 2;
        System.out.println(findPoisonedDuration(timeSeries, duration));
    }
}
