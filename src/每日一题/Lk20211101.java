package 每日一题;

import java.util.HashSet;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211101
 * @description: 分糖果
 * @date 2021-11-01
 */
public class Lk20211101 {
    public static int distributeCandies(int[] candyType) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : candyType) {
            if (!set.contains(i)) {
                res++;
                set.add(i);
            }
            if (res == candyType.length / 2) {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3};
        System.out.println(distributeCandies(arr));
    }
}
