package 每日一题;

import java.util.HashSet;
import java.util.Set;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211106
 * @description: 丢失的数字
 * @date 2021-11-06
 */
public class LK20211106 {
    /**
     * @Author W.Wen
     * @Description hashSet版本
     * @Date 2021/11/6
     * @Param [nums]
     * @return int
     **/
    public static int missingNumber(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        int res=0;
        for (int num : nums) {
            integers.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if(!integers.contains(i)){
                res=i;
            }
        }
        return res;
    }

    /**
     * @Author W.Wen
     * @Description 位运算版本
     * @Date 2021/11/6
     * @Param [nums]
     * @return int
     **/
    public static int missingNumber2(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res^=i;
            res^=nums[i];
        }
        res^=nums.length;
        return res;
    }

    public static void main(String[] args) {
        int[] arr={3,0,1};
        System.out.println(missingNumber2(arr));
    }
}
