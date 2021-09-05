package 常见题目;

/**
 * @author 王文
 * @version : V1.0
 * @className: TwoTuple
 * @description: 获取二元组
 * @date 2021-09-05
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有序数组arr,给定一个正数aim,返回累加和为aim的，所有不同的二元组
 * 思路：利用双指针和单调性
 */

public class TwoTuple {
    public static List<int[]> getTwoTuple(int[] arr, int aim) {
        if(arr.length<2||arr==null){
            return null;
        }
        int left = 0;
        int right = arr.length - 1;
        ArrayList<int[]> res = new ArrayList<>();
        while (right > left) {
            if (arr[left] + arr[right] > aim) {
                right--;
            } else if (arr[left] + arr[right] == aim) {
                if (left == 0 || (arr[left] != arr[left - 1])) {
                    res.add(new int[]{arr[left], arr[right],0});
                }
                right--;
                left++;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={-6,-3,-1,0,2,4,6,7,9,12};
        List<int[]> twoTuple = getTwoTuple(arr, 6);
        System.out.println(twoTuple);
    }
}
