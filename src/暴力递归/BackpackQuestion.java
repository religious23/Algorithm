package 暴力递归;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: BackpackQuestion
 * @description: 背包问题  从左往右的尝试模型
 * @date 2021-03-28
 */

/**
 * 给定两个长度都为N的数组weights和values
 * weights[i]和value[i]分别代表i号物品的重量和价值
 * 给定一个正数bag,表示一个载重为bag的袋子
 * 你装的物品不能超过这个重量
 * 返回你能装下最多的价值是多少？
 */
public class BackpackQuestion {
    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, 0, bag);
    }

    //三个参数不变：w[]  v[]  bag
    //0..index-1上做了货物的选择，使得你已经达到的重量是多少alreadyW
    //如果返回-1，认为没有方案
    //如果不返回-1，认为返回的值是一个真实的价值
    public static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        if (alreadyW > bag) {
            return -1;
        }
        //重量没超
        if (index == w.length) {
            return 0;
        }
        int p1 = process(w, v, index + 1, alreadyW, bag);
        int p2next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2next == -1) {
            p2 = v[index] + p2next;
        }
        return Math.max(p1, p2);
    }

}
