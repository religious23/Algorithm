package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: LK20210418
 * @description: 不利用额外空间 实现数组去重
 * @date 2021-04-18
 */
public class LK20210418 {
    public static int getArray(int[] arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int p = 0;
        int q = 1;
        while (q < arr.length-1) {
            if (arr[p] == arr[q]) {
                q++;
            } else {
                arr[++p]=arr[q++];
            }
        }
        return p+1;
    }

    public static void main(String[] args) {
        int[] arr={1,3,3,3,3,3,4,5,5,6,7,8,8,8};
        int array = getArray(arr);
        System.out.println(array);
    }
}
