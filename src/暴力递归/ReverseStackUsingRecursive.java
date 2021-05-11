package 暴力递归;

import java.util.Stack;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: ReverseStackUsingRecursive
 * @description: 不申请额外数据结构，将一个栈逆序
 * @date 2021-03-26
 */
public class ReverseStackUsingRecursive {
    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        System.out.println(stack);
    }
}
