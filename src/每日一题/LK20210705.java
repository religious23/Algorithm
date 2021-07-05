package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210705
 * @description: 错误的集合（位运算）
 * @date 2021-07-04
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LK20210705 {
    public static int[] findErrorNums(int[] nums) {
        int temp=0;
        int resOne=0;
        int resTwo=0;
        boolean flag=false;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            list.add(i+1);
            temp=temp^nums[i] ^ (i + 1);
        }
        for (int i = 0; i < list.size(); i++) {
            if(((~temp+1)&temp&list.get(i))==0){
                resOne=resOne^list.get(i);
            }
            else{
                resTwo=resTwo^list.get(i);
            }
        }
        for (int num : nums) {
            if(resOne==num){
                flag=true;
                break;
            }
        }
        return flag?new int[]{resOne,resTwo}:new int[]{resTwo,resOne};
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,3,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
}
