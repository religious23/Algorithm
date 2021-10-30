package 每日一题;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211028
 * @description: 判断排序后是否是2的次幂  利用哈希表判断 %10取最后一位数
 * @date 2021-10-28
 */
public class LK20211028 {
    public static boolean reorderedPowerOf2(int n) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; Math.pow(2, i) < Math.pow(10, 9); i++) {
            int[] ints = new int[10];
            int M = (int) Math.pow(2, i);
            while (M != 0) {
                int a = M % 10;
                M = M / 10;
                ints[a] += 1;
            }
            set.add(Arrays.toString(ints));
        }
        int[] ints = new int[10];
        while (n != 0) {
            int a = n % 10;
            n = n / 10;
            ints[a]+=1;
        }
        return set.contains(Arrays.toString(ints));
    }

    public static void main(String[] args) {
        int n=61;
        System.out.println(reorderedPowerOf2(n));
    }
}
