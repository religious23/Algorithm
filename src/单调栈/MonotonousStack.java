package 单调栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 王文
 * @version : V1.0
 * @className: MonotonousStack
 * @description: 单调栈
 * @date 2021-05-08
 */
public class MonotonousStack {
    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        //List<Integer> ->放的是位置，同样值的东西，位置压在一起
        //代表值，底->顶 由小到大
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popI : popIs) {
                    res[popI][0] = leftLessIndex;
                    res[popI][1] = i;
                }
            }

            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popI : popIs) {
                res[popI][0] = leftLessIndex;
                res[popI][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 7, 8, 95, 12, 41, 2, 3, 5, 2, 32, 12};
        int[][] ints = getNearLess(arr);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
