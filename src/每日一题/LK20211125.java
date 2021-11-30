package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211125
 * @description: 可怜的小猪
 * @date 2021-11-25
 */
public class LK20211125 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int time = (minutesToTest / minutesToDie) + 1;
        int res = 1;
        int m = time;
        for (; m < buckets; res++) {
            m *= time;
        }
        return res;
    }

    public static void main(String[] args) {
        LK20211125 lk20211125 = new LK20211125();
        System.out.println(lk20211125.poorPigs(4, 15, 45));
    }
}
