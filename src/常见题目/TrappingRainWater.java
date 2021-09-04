package 常见题目;

/**
 * @author 王文
 * @version : V1.0
 * @className: TrappingRainWater
 * @description: 求最大积水量
 * @date 2021-09-04
 */

/**
 * 给定一个数组arr,已知其中所有的值都是非负的，将这个数组
 * 看作一个容器，请返回容器能装多少水
 * 比如，arr={3,1,2,5,2,4},根据值画出的直方图就是容器形状，该
 * 容器可以装下5格水
 */
public class TrappingRainWater {
    public static int getWater(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        while (right >= left) {
            if (maxLeft <= maxRight) {
                res += Math.max(0, maxLeft - arr[left]);
                maxLeft = Math.max(maxLeft, arr[left++]);
            } else {
                res += Math.max(0, maxRight - arr[right]);
                maxRight = Math.max(maxRight, arr[right--]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 2, 4};
        int water = getWater(arr);
        System.out.println(water);
    }
}
