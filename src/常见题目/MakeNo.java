package 常见题目;

/**
 * @author 王文
 * @version : V1.0
 * @className: MakeNo
 * @description: 生成一个长度为K的数组，满足任意三个相连的数，两边数相加不等于中间数的两倍
 * @date 2021-08-14
 */

public class MakeNo {
    public static int[] makeNo(int size) {
        if (size == 1) {
            return new int[]{1};
        }
        int halfSize = (size + 1) >> 1;
        int[] temp = makeNo(halfSize);
        int[] res = new int[size];
        int index = 0;
        for (; index < halfSize; index++) {
            res[index] = temp[index] * 2 + 1;
        } //获取奇数
        for (int i = 0; index < halfSize; index++, i++) {
            res[index] = temp[i] * 2;
        } //获取偶数
        return res;
    }
}
