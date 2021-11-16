package 每日一题;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211116
 * @description: 完美矩形
 * @date 2021-11-16
 */
public class LK20211116 {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length < 2) {
            return true;
        }
        Set<String> set = new HashSet<>();
        for (int[] rectangle : rectangles) {
            String point = new Point(rectangle[0], rectangle[1]).toString();
            if (set.contains(point)) {
                set.remove(point);
            } else {
                set.add(point);
            }
            point = new Point(rectangle[2], rectangle[3]).toString();
            if (set.contains(point)) {
                set.remove(point);
            } else {
                set.add(point);
            }
            point = new Point(rectangle[0], rectangle[3]).toString();
            if (set.contains(point)) {
                set.remove(point);
            } else {
                set.add(point);
            }
            point = new Point(rectangle[2], rectangle[1]).toString();
            if (set.contains(point)) {
                set.remove(point);
            } else {
                set.add(point);
            }
        }
        if (set.size() != 4) {
            return false;
        }
        Object[] points = set.toArray();
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;
        for (Object point : points) {
            String[] split = point.toString().split("_");
            a = Math.min(a, Integer.parseInt(split[0]));
            b = Math.min(b, Integer.parseInt(split[1]));
            c = Math.max(c, Integer.parseInt(split[0]));
            d = Math.max(d, Integer.parseInt(split[1]));
        }
        int s = getS(a, b, c, d);
        int s1 = 0;
        for (int[] rectangle : rectangles) {
            int s2 = getS(rectangle[0], rectangle[1], rectangle[2], rectangle[3]);
            s1 += s2;
        }
        return s1 == s;
    }


    public int getS(int a, int b, int c, int d) {
        return (c - a) * (d - b);
    }

    public class Point {
        private int x;
        private int y;

        @Override
        public String toString() {
            return x + "_" + y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        LK20211116 lk20211116 = new LK20211116();
        System.out.println(lk20211116.isRectangleCover(rectangles));
    }

}
