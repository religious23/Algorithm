package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210616
 * @description: 石子问题
 * @date 2021-06-16
 */

/**
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 */
public class LK20210616 {
    public boolean stoneGame(int[] piles) {
        if (piles == null) {
            return false;
        }
        if (piles.length == 1) {
            return true;
        }
        int N = piles.length;
        int[][] f = new int[N][N];
        int[][] l = new int[N][N];
        for (int i = 0; i <= N - 1; i++) {
            f[i][i] = piles[i];
            l[i][i] = 0;
        }
        /*if (L == R) {
            return arr[L];
        }*/
        for (int i = 1; i < N; i++) {
            int row = 0;
            int col = i;
            while (row < N && col < N) {
                f[row][col] = Math.max(l[row + 1][col] + piles[row], l[row][col - 1] + piles[col]);
                l[row][col] = Math.min(f[row + 1][col], f[row][col - 1]);
                row++;
                col++;
            }
        }
        return f[0][N - 1] > l[0][N - 1];
    }
}
