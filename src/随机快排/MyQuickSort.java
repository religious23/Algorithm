package 随机快排;

import java.util.Arrays;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: MyQuickSort
 * @description: 手撕快排
 * @date 2021-04-10
 */
public class MyQuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] ints = heNan(arr, L, R);
        process(arr, L, ints[0]);
        process(arr, ints[1], R);
    }

    private static int[] heNan(int[] arr, int L, int R) {
        if (L == R) {
            return new int[]{L, L};
        }
        int less = L - 1;
        int more = R;
        for (int i = L; i < more; i++) {
            if (arr[i] < arr[R]) {
                swap(arr, i, ++less);
            } else if (arr[i] > arr[R]) {
                swap(arr, i--, --more);
            }
        }
        swap(arr, more++, R);
        return new int[]{less, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 37, 16, 46, 41, 6, 7, 8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
