package 常见题目;

/**
 * @author 王文
 * @version : V1.0
 * @className: ThreeTuple
 * @description: 三元组
 * @date 2021-09-05
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 在二元组的基础上做三元组
 */
public class ThreeTuple {
    public static List<int[]> getThreeTuple(int[] arr, int aim) {
        if (arr.length < 3) {
            return null;
        }
        List<int[]> threeTuple = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if(i>0&&arr[i]==arr[i-1]){
                continue;
            }
            int[] ints = new int[arr.length - 1 - i];
            for (int j = 0; j < ints.length; j++) {
                ints[j] = arr[j + i + 1];
            }
            List<int[]> tempTuple = TwoTuple.getTwoTuple(ints, aim-arr[i]);
            if (tempTuple != null) {
                for (int[] ints1 : tempTuple) {
                    ints1[2] = arr[i];
                    threeTuple.add(ints1);
                }
            }
        }
        return threeTuple;
    }

    public static void main(String[] args) {
        int[] arr={-6,-3,-1,0,2,4,6,7,9,12};
        List<int[]> twoTuple = getThreeTuple(arr, 6);
        System.out.println(twoTuple);
    }
}
