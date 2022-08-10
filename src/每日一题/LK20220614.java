package 每日一题;

import java.util.Arrays;

/**
 * @author xc-ww
 * @version : V1.0
 * @className: LK20220614
 * @description: 对角线遍历
 * @date 2022-06-14
 */
public class LK20220614 {
    public static int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        int index = 0;
        //false 向上 true 向下
        boolean direction = true;
        for (int i = 0, j = 0; index != res.length; ) {
            res[index] = mat[i][j];
            index++;
            if (j == mat[0].length - 1 && direction) {
                i++;
                direction = false;
                continue;
            }
            if (i == 0 && direction) {
                j++;
                direction = false;
                continue;
            }
            if (i == mat.length - 1 && !direction) {
                j++;
                direction = true;
                continue;
            }
            if (j == 0 && !direction) {
                i++;
                direction = true;
                continue;
            }
            if (direction) {
                i--;
                j++;
                continue;
            }
            i++;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = {{6, 9, 7}};
        System.out.println(Arrays.toString(findDiagonalOrder(ints)));
    }
}
