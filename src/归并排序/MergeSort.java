package 归并排序;

import java.util.Arrays;

/**
 * @author 王文
 * @date 2021/1/4 14:58
 */
public class MergeSort {
    //递归方法实现
    private static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {

        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        //步长
        int mergeSize = 1;
        while (mergeSize < N) {//log N
            //当前左组的，第一个位置
            int L = 0;
            while (L < N){
                if(mergeSize>=N-L){
                    break;
                }
                int M=L+mergeSize-1;
                int R=M+Math.min(mergeSize,N-M-1);
                merge(arr,L,M,R);
                L=R+1;
            }
            //防止溢出
            if(mergeSize>N/2){
                break;
            }
            mergeSize<<=1;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 5, 8, 3, 2};
        mergeSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
