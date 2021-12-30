package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211217
 * @description: 换酒问题
 * @date 2021-12-17
 */
public class LK20211217 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) {
            return numBottles;
        }
        int res = 0;
        int rest = numBottles;
        while (rest >= numExchange) {
            res += numExchange * (rest / numExchange);
            rest = rest % numExchange + rest / numExchange;
        }
        res += rest;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(5, 5));
    }
}
