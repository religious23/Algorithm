package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211026
 * @description: 下一个更大元素I
 * @date 2021-10-26
 */
public class LK20211026 {

    public static class Node {

        private Integer index;
        private Integer value;

        public Node(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] maxArr = new int[nums2.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            maxArr[i] = -1;
            while (!stack.isEmpty() && stack.peek().value < nums2[i]) {
                Node pop = stack.pop();
                maxArr[pop.index] = nums2[i];
            }
            stack.push(new Node(i, nums2[i]));
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = maxArr[map.get(nums1[i])];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] num1 = {2, 4};
        int[] num2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(num1, num2)));
    }
}
