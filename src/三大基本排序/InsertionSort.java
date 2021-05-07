package 三大基本排序;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] integers = insertionSort(new int[]{8, 1, 3, 9, 7, 4, 5, 2});
        System.out.println(Arrays.toString(integers));
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(j, j - 1, arr);
                }
            }
        }
        return arr;
    }

    private static void swap(Integer j, Integer index, int[] arr) {
        Integer temp = arr[j];
        arr[j] = arr[index];
        arr[index] = temp;
    }
}
