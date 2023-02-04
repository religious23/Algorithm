package 每日一题;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author xc-ww
 * @version : V1.0
 * @className: LK20230204
 * @description: 给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。第 i 个硬币的值为 coins[i] 。如果你从这些硬币中选出一部分硬币，它们的和为 x ，那么称，你可以 构造 出 x 。
 * <p>
 * 请返回从 0 开始（包括 0 ），你最多能 构造 出多少个连续整数。
 * <p>
 * 你可能有多个相同值的硬币。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023-02-04
 */
public class LK20230204 {
    public static int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int max = 0;
        for (int coin : coins) {
            if (coin > max + 1) {
                return max + 1;
            }
            max += coin;
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 4, 10};
        System.out.println(getMaximumConsecutive(arr));
    }
}
