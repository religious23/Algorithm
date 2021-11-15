package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211115
 * @description: 灯泡开关
 * @date 2021-11-15
 */
public class LK20211115 {
    public static int bulbSwitch(int n) {
        int res = 0;
        int L = 0;
        int R = n;
        while (R >= L) {
            int mid = (R - L) / 2 + L;
            long sqrM=(long) mid * mid;
            if (sqrM == n) {
                res = mid;
                break;
            }
            if (sqrM < n) {
                L = mid + 1;
            }
            else{
                R = mid - 1;
            }
            res=R;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(3));
    }
}
