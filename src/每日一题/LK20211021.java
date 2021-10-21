package 每日一题;

import java.util.Arrays;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211021
 * @description: 加一
 * @date 2021-10-21
 */
public class LK20211021 {
    /**
     * @Author W.Wen
     * @Description 利用整数版本
     * @Date 2021/10/21
     * @Param [digits]
     * @return int
     **/
    public static int[] plusOne1(int[] digits) {
        String str="";
        for (int digit : digits) {
            str+=digit;
        }
        int i = Integer.parseInt(str);
        i=i+1;
        char[] chars = String.valueOf(i).toCharArray();
        int[] ints = new int[chars.length];
        for (int j = 0; j < ints.length; j++) {
            ints[j]=Integer.parseInt(chars[j]+"");
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] arr={9,9,9};
        System.out.println(Arrays.toString(plusOne1(arr)));
        System.out.println(Arrays.toString(plusOne2(arr)));
    }

    /**
     * @Author W.Wen
     * @Description 自己对数组进行操作的版本
     * @Date 2021/10/21
     * @Param
     * @return null
     **/
    public static int[] plusOne2(int[] digits) {
        for (int j = digits.length-1; j >=0; j--) {
            if(digits[j]!=9){
                digits[j]++;
                break;
            }
            digits[j]=0;
            if(j==0){
                int[] ints = new int[digits.length + 1];
                ints[0]=1;
                digits=ints;
            }
        }
        return digits;
    }
}
