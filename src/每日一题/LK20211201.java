package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211201
 * @description: 连续字符
 * @date 2021-12-01
 */
public class LK20211201 {
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int temp = 1;
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == chars[i - 1]) {
                temp++;
            } else {
                res = Math.max(res, temp);
                temp = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LK20211201 lk20211201 = new LK20211201();
        System.out.println(lk20211201.maxPower("abbcccddddeeeeedcba"));
    }
}
