package 三大基本排序;

import java.util.Arrays;

/**
 * 选择排序(Selection-sort)是一种简单直观的排序算法。
 * 它的工作原理：首先在未排序序列中找到最小（大）元素，
 * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort {
    public static void main(String[] args) {
        Integer[] integers = selectionSort(new Integer[]{1, 3, 9, 7, 4, 5, 2});
        System.out.println(Arrays.toString(integers));
    }


    public static Integer[] selectionSort(Integer[] arr) {
        for (int j = 0; j < arr.length; j++) {
            Integer min = arr[j];
            Integer index = j;
            for (int i = j+1; i < arr.length ; i++) {
                if (min > arr[i]) {
                    min=arr[i];
                    index = i;
                }
            }
            swap(j, index, arr);
        }
        return arr;
    }

    private static void swap(Integer j, Integer index, Integer[] arr) {
        Integer temp = arr[j];
        arr[j] = arr[index];
        arr[index] = temp;
    }
}
