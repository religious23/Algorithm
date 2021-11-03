package 每日一题;

import 常见题目.TrappingRainWaterII;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211103
 * @description:  能积水问题 二维版
 * @date 2021-11-03
 */
public class LK20211103 {

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
            if (head.col > 0 && !isEnter[head.row][head.col - 1]) {
                res += Math.max(max - heightMap[head.row][head.col - 1], 0);
                isEnter[head.row][head.col - 1]=true;
                queue.add(new Head(heightMap[head.row][head.col - 1], head.row, head.col - 1));
            }
            if (head.col < heightMap[0].length - 1 && !isEnter[head.row][head.col + 1]) {
                res += Math.max(max - heightMap[head.row][head.col + 1], 0);
                isEnter[head.row][head.col + 1]=true;
                queue.add(new Head(heightMap[head.row][head.col + 1], head.row, head.col + 1));
            }
            if (head.row > 0 && !isEnter[head.row - 1][head.col]) {
                res += Math.max(max - heightMap[head.row - 1][head.col], 0);
                isEnter[head.row - 1][head.col]=true;
                queue.add(new Head(heightMap[head.row - 1][head.col], head.row - 1,head.col));
            }
            if (head.row < heightMap.length - 1 && !isEnter[head.row + 1][head.col]) {
                res += Math.max(max - heightMap[head.row + 1][head.col], 0);
                isEnter[head.row + 1][head.col]=true;
                queue.add(new Head(heightMap[head.row + 1][head.col], head.row + 1, head.col));
            }
        }
        return res;
    }


    private static boolean[][] getIsEnter(int[][] heightMap) {
        return new boolean[heightMap.length][heightMap[0].length];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        System.out.println(trapRainWater(arr));
    }
}
