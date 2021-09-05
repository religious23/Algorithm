package 常见题目;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 王文
 * @version : V1.0
 * @className: TrappingRainWaterII
 * @description: 能积水问题 二维版
 * @date 2021-09-04
 */
public class TrappingRainWaterII {

    public static class Head {
        private Integer value;
        private Integer row;
        private Integer col;

        public Head(Integer value, Integer row, Integer col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap.length < 3 || heightMap[0].length < 3) {
            return 0;
        }

        PriorityQueue<Head> queue = new PriorityQueue<Head>(new Comparator<Head>() {
            @Override
            public int compare(Head o1, Head o2) {
                return o1.value - o2.value;
            }
        });

        boolean[][] isEnter = getIsEnter(heightMap);

        for (int i = 0; i < heightMap[0].length; i++) {
            Head head = new Head(heightMap[0][i], 0, i);
            queue.add(head);
            isEnter[0][i] = true;
        }

        for (int i = 0; i < heightMap[0].length; i++) {
            Head head = new Head(heightMap[heightMap.length - 1][i], heightMap.length - 1, i);
            queue.add(head);
            isEnter[heightMap.length - 1][i] = true;
        }

        for (int i = 1; i < heightMap.length - 1; i++) {
            Head head = new Head(heightMap[i][heightMap[0].length - 1], i, heightMap[0].length - 1);
            queue.add(head);
            isEnter[i][heightMap[0].length - 1] = true;
        }

        for (int i = 1; i < heightMap.length - 1; i++) {
            Head head = new Head(heightMap[i][0], i, 0);
            queue.add(head);
            isEnter[i][0] = true;
        }

        int max = 0;
        int res = 0;
        while (!queue.isEmpty()) {
            Head head = queue.poll();
            max = Math.max(max, head.value);
            if (head.col > 0 && !isEnter[head.col - 1][head.row]) {
                res += Math.max(max - heightMap[head.col - 1][head.row], 0);
                queue.add(new Head(heightMap[head.col - 1][head.row], head.col - 1, head.row));
            }
            if (head.col < heightMap[0].length - 1 && !isEnter[head.col + 1][head.row]) {
                res += Math.max(max - heightMap[head.col + 1][head.row], 0);
                queue.add(new Head(heightMap[head.col + 1][head.row], head.col + 1, head.row));
            }
            if (head.row > 0 && !isEnter[head.col][head.row - 1]) {
                res += Math.max(max - heightMap[head.col][head.row - 1], 0);
                queue.add(new Head(heightMap[head.col][head.row - 1], head.col, head.row - 1));
            }
            if (head.col < heightMap.length - 1 && !isEnter[head.col][head.row + 1]) {
                res += Math.max(max - heightMap[head.col + 1][head.row], 0);
                queue.add(new Head(heightMap[head.col][head.row + 1], head.col, head.row + 1));
            }
        }
        return res;
    }


    private static boolean[][] getIsEnter(int[][] heightMap) {
        return new boolean[heightMap.length][heightMap[0].length];
    }
}
