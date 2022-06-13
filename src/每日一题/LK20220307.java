package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20220307
 * @description: 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出
 * @date 2022-03-07
 */
public class LK20220307 {
    public String convertToBase7(int num) {
        int length = 1;
        for (int i = 1; Math.pow(7, i) <= num; i++) {
            length++;
        }
        StringBuilder res = new StringBuilder();
        int temp = (int) Math.pow(7, length - 1);
        while (num >= 7) {
            res.append(num / temp);
            num = num % temp;
            temp = temp / 7;
        }
        for (int i = 0; i < length - res.length() - 1; i++) {
            res.append("0");
        }
        res.append(num);
        return res.toString();
    }

    public static void main(String[] args) {
        LK20220307 lk20220307 = new LK20220307();
        System.out.println(lk20220307.convertToBase7(-7));
    }
}
