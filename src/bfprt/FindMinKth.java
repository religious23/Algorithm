package bfprt;

/**
 * @author 王文
 * @version : V1.0
 * @className: FindMinKth
 * @description: 寻找数组中的第k小的值
 * @date 2021-05-19
 */
public class FindMinKth {

    /**
     * @return int
     * @Author 王文
     * @Description 寻找数组中的第k小的值
     * @Date 2021/5/19
     * @Param [arr, k]
     **/
    public static int getMinKth(int[] arr, int k) {
        if (arr == null || k > arr.length) {
            return -1;
        }
        int[] arr1 = copyArray(arr);
        return process2(arr1, 0, arr.length - 1, k - 1);
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i != ans.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    //arr[L...R] 范围上，如果排序的话（不是真的排序），找位于index的数
    //index 一定在[L...R]上
    public static int process2(int[] arr, int L, int R, int index) {
        if (L == R) {
            return arr[L];
        }
        //不止一个数
        int pivot = arr[L + (int) (Math.random() * (R - L + 1))];

        int[] range = partition(arr, L, R, pivot);
        //range[0] range[1]
        //L ... R   pivot
        if (index >= range[0] && index <= range[1]) {
            return arr[index];
        } else if (index < range[0]) {
            return process2(arr, L, range[0] - 1, index);
        } else {
            return process2(arr, range[1] + 1, R, index);
        }
    }

    private static int[] partition(int[] arr, int L, int R, int pivot) {
        int less = L - 1;
        int more = R + 1;
        int index = L;
        while (index < more) {
            if (arr[index] < pivot) {
                swap(arr, index++, ++less);
            } else if (arr[index] == pivot) {
                index++;
            } else {
                swap(arr, index, --more);
            }
        }
        //swap(arr, more, R);
        return new int[]{less + 1, more - 1};
    }

    /**
     * @return void
     * @Author W.Wen
     * @Description 数组中的元素交换
     * @Date 2021/1/22
     * @Param [arr, i, i1]
     **/
    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    public static int minKth(int[] array, int k) {
        int[] arr = copyArray(array);
        return bfprt(arr, 0, arr.length - 1, k - 1);
    }

    //arr[L..R] 如果排序的话，位于index位置的数
    public static int bfprt(int[] arr, int L, int R, int index) {
        if (L == R) {
            return arr[L];
        }
        int pivot = medianOfMedians(arr, L, R);
        int[] range = partition(arr, L, R, pivot);
        //range[0] range[1]
        //L ... R   pivot
        if (index >= range[0] && index <= range[1]) {
            return arr[index];
        } else if (index < range[0]) {
            return process2(arr, L, range[0] - 1, index);
        } else {
            return process2(arr, range[1] + 1, R, index);
        }
    }

    //arr[L...R] 五个数一组
    //每个小组内部排序
    //每个小组中位数拿出来，组成marr
    //marr中的中位数，返回
    private static int medianOfMedians(int[] arr, int L, int R) {
        int size = R - L + 1;

        int offset = size % 5 == 0 ? 0 : 1;

        int[] mArr = new int[size / 5 + offset];
        for (int team = 0; team < mArr.length; team++) {
            int teamFirst = L + team * 5;
            mArr[team] = getMedian(arr, teamFirst, Math.min(R, teamFirst + 4));
        }
        //mArr中，找到中位数
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int L, int R) {
        insertionSort(arr);
        return arr[(L + R) >> 1];
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

    public static void main(String[] args) {
        int[] arr = {0,2,1,0};
        int k = 4;
        System.out.println(getMinKth(arr, k));
    }
}
