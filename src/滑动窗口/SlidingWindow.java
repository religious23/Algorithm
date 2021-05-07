package 滑动窗口;

/**
 * @author 王文
 * @version : V1.0
 * @className: SlidingWindow
 * @description: 滑动窗口 滑动窗口的数据结构 用一个双向队列实现
 * @date 2021-04-14
 */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 假设一个固定大小为W的窗口，依此滑过arr，
 * 返回每一次滑出状况的最大值
 *
 * @author 王文
 */

public class SlidingWindow {
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        //其中放的是位置，arr[位置] 值 大->小
        LinkedList<Integer> qmax = new LinkedList<>();

        //放结果的数组
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int R = 0; R < arr.length; R++) {
            //R位置所代表的值可以放在比他大的值后，或者空
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            //数进来了
            //如果窗口没有形成w长度之前，不弹出数字.
            if (qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }

            if (R >= w - 1) {
                res[index++]=arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={3,4,2,5,6,7,3,8,5};
        int w=4;
        int[] maxWindow = getMaxWindow(arr, w);
        System.out.println(Arrays.toString(maxWindow));
    }
}
