package 常见题目;

/**
 * @author 王文
 * @version : V1.0
 * @className: CordCoverMaxPoint
 * @description: 最大覆盖长度
 * @date 2021-07-24
 * <p>
 * 给定一个有序数组arr,从左到右依此表示X轴上从左到右的位置
 * 给定一个正整数K，返回如果有一根长度为K的绳子，最多能盖住几个点
 * 绳子的边缘点碰到X轴上的点，也算盖住
 */

/**
 * 利用滑动窗口（因为有单调性） 也有点小贪心 只算节点
 */

public class CordCoverMaxPoint {
    public int cordCoverMaxPoint(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int n = arr.length;
        int max = 0;
        while (right < n && left <= right) {
            while (right < n && arr[right] - arr[left] <= k) {
                right++;
            }
            max = Math.max(right - (left++), max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 8, 9};
        int k = 3;
        CordCoverMaxPoint cordCoverMaxPoint = new CordCoverMaxPoint();
        System.out.println(cordCoverMaxPoint.cordCoverMaxPoint(arr, k));
    }
}
