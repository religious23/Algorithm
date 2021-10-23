package 每日一题;

import java.util.Arrays;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211023
 * @description: 构造矩阵
 * @date 2021-10-23
 */
public class Lk20211023 {
    public static int[] constructRectangle(int area) {
        int[] ints = new int[2];
        for (int i = (int) Math.sqrt(area); i > 0; i--) {
            if(area%i==0){
                ints[0]=area/i;
                ints[1]=i;
                break;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        int area=122122;
        System.out.println(Arrays.toString(constructRectangle(area)));
    }
}
