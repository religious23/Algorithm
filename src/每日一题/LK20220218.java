package 每日一题;

import java.util.HashSet;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20220218
 * @description: 找出星型图的中心节点
 * @date 2022-02-18
 */
public class LK20220218 {
    public static int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];
        HashSet<Integer> set = new HashSet<>();
        set.add(a);
        if (set.contains(b)) return b;
        set.add(b);
        if (set.contains(c)) return c;
        set.add(c);
        if (set.contains(d)) return d;
        return 0;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(findCenter(edges));
    }
}
