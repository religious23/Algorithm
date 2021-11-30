package 每日一题;

import java.util.*;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211127
 * @description: 随机翻转矩阵
 * @date 2021-11-28
 */
public class LK20211127 {

    class SolutionOne {
        Map<Integer, Integer> map = new HashMap<>();
        int m, n, total;
        Random rand = new Random();

        public SolutionOne(int m, int n) {
            this.m = m;
            this.n = n;
            this.total = m * n;
        }

        public int[] flip() {
            int x = rand.nextInt(total);
            total--;
            // 查找位置 x 对应的映射
            int idx = map.getOrDefault(x, x);
            // 将位置 x 对应的映射设置为位置 total 对应的映射
            map.put(x, map.getOrDefault(total, total));
            return new int[]{idx / n, idx % n};
        }

        public void reset() {
            total = m * n;
            map.clear();
        }
    }


    static class Solution {
        int index;
        List<String> list;
        Random random;

        public Solution(int m, int n) {
            random = new Random();
            list = new ArrayList<>(m * n);
            index = m * n - 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    list.add(i + ":" + j);
                }
            }
        }

        public int[] flip() {
            if (index < 0) {
                return null;
            }
            int i = random.nextInt(index + 1);
            int[] res = Arrays.stream(list.get(i).split(":")).mapToInt(Integer::parseInt).toArray();
            swap(i, index);
            index--;
            return res;
        }

        private void swap(int i, int index) {
            String temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }

        public void reset() {
            index = list.size() - 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1000,1000);
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
    }
}
