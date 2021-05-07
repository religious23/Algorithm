package 随机快排;

import java.util.Arrays;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: QuickSort
 * @description: 快速排序
 * @date 2021-01-22
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 16, 46, 41, 6, 7, 8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        liucheng(arr, 0, arr.length - 1);
    }

    /**
     * @Author W.Wen
     * @Description 流程控制的方法
     * @Date 2021/1/22
     * @Param [arr, L, R]
     * @return void
     **/
    public static void liucheng(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        /*使每次选择的数都随机*/
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] ints = heNan(arr, L, R);
        liucheng(arr, L, ints[0]);
        liucheng(arr, ints[1], R);
    }

    /**
     * @Author W.Wen
     * @Description 将数组分为三块 > < = (荷兰国旗问题）
     * @Date 2021/1/22
     * @Param [arr, L, R]
     * @return int
     **/

    public static int[] heNan(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else if (arr[index] == arr[R]) {
                index++;
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[]{less, ++more};
    }

    /**
     * @Author W.Wen
     * @Description 数组中的元素交换
     * @Date 2021/1/22
     * @Param [arr, i, i1]
     * @return void
     **/
    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}