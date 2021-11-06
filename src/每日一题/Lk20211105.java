package 每日一题;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211105
 * @description: 最长定差子序列
 * @date 2021-11-05
 */
public class Lk20211105 {
    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : arr) {
            if (map.containsKey(i - difference)) {

                if (map.containsKey(i)) {
                    map.put(i, Math.max(map.get(i - difference) + 1, map.get(i)));
                } else {
                    map.put(i, map.get(i - difference) + 1);
                }
            } else {
                map.put(i, 1);
            }
            res = Math.max(res, map.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        int difference = 0;
        System.out.println(longestSubsequence(arr, difference));
    }
}
