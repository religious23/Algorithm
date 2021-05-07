package 三大基本排序;

import java.util.Arrays;

/**
 * 冒泡排序：冒泡排序是一种简单的排序算法。
 * 它重复地走访过要排序的数列，一次比较两个元素，
 * 如果它们的顺序错误就把它们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，
 * 也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] integers = bubbleSort(new Integer[]{1, 3, 9, 7, 4, 5, 2});
        System.out.println(Arrays.toString(integers));
    }

    public static Integer[] bubbleSort(Integer[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j,arr);
                }
            }
        }
        return arr;
    }

    private static void swap(Integer j,Integer[] arr) {
        Integer temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }

}
