package 滑动窗口;

import java.util.LinkedList;

/**
 * @author 王文
 * @version : V1.0
 * @className: AllLessNumSubArray
 * @description: 求所有的满足条件的子数组
 * @date 2021-05-07
 */
public class AllLessNumSubArray {
    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int L = 0;
        int R = 0;
        //[L..R) ->[0,0) 窗口内无数 [1,1)
        int res = 0;
        while (L < arr.length) {
            //如果此时窗口的开头是L
            while (R < arr.length) {
                //R是最后一个达标位置的再下一个
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);

                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                R++;
            }
             if(qmin.peekFirst()==L){
                qmin.pollFirst();
            }//R是最后一个达标位置的再下一个，第一个违规的位置
            res+=R-L;

            if(qmin.peekFirst()==L){
                qmin.pollFirst();
            }
            if(qmax.peekFirst()==L){
                qmax.pollFirst();
            }

            L++;
        }
        return res;
    }
}
