package 每日一题;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.concurrent.ForkJoinPool;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211025
 * @description: 搜索二维矩阵 II
 * @date 2021-10-25
 */
public class LK20211025 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        boolean res = false;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                res = true;
                break;
            }
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-5}};
        System.out.println(searchMatrix(matrix, -5));
    }
}
