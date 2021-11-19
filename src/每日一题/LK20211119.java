package 每日一题;

import java.util.HashMap;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211119
 * @description: 整数替换
 * @date 2021-11-19
 */
public class LK20211119 {
    public int integerReplacement(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(Integer.MAX_VALUE,32);
        return process(n, map);
    }

    private int process(int n, HashMap<Integer, Integer> map) {
        if (n == 1) {
            return 0;
        }
        int res;
        if (map.containsKey(n)) {
            res = map.get(n);
        } else if (n % 2 == 0) {
            res = process(n >>1, map) + 1;
        } else {
            int p1 = process(n + 1, map) + 1;
            int p2 = process(n - 1, map) + 1;
            res = Math.min(p1, p2);
        }
        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        LK20211119 lk20211119 = new LK20211119();
        System.out.println(lk20211119.integerReplacement(a));
    }
}
