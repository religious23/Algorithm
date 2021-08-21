package 常见题目;

/**
 * @author 王文
 * @version : V1.0
 * @className: PackingMachine
 * @description: 将数量移动平均的最少步数
 * @date 2021-08-21
 */

import java.util.stream.IntStream;

/**
 * 有n个打包机器从左到右一字排开，上方有一个自动装置会抓取一批物品到每个打包机上
 * 放到每个机器上的这些物品数量有多有少。每次只能搬一个物品进行移动，为了省力，
 * 只能在相邻的机器上移动，请计算在搬动最小轮数的前提下，使每个机器上的物品数量相等
 */

public class PackingMachine {
    public static int getMinNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = IntStream.of(arr).sum();
        if ((sum % arr.length) != 0) {
            return -1;
        }
        int average = sum / arr.length;
        int tempSum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            //关键一步 贪心
            int left = tempSum - average * (i);
            int right = (sum - tempSum) - average * (arr.length - i - 1);
            int p = (left < 0 && right < 0) ? Math.abs(left + right) : Math.max(Math.abs(left), Math.abs(right));
            ans = Math.max(ans, p);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 13, 10};
        System.out.println(getMinNum(arr));
    }

}
