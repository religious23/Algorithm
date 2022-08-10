package 暴力递归;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: TwoPlayerCardProblem
 * @description: 双人纸牌问题
 * @date 2021-03-28
 */


/**
 * 给定一个整数数组arr，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌
 * 规定玩家A先拿，玩家B后拿
 * 但是每个玩家只能拿走最左或最右的纸牌
 * 玩家A和玩家B都绝顶聪明，请返回最后获胜者的分数
 */
public class TwoPlayerCardProblem {
    public static String getWin(int[] arr) {
        if (arr == null) {
            return "没有牌，无法游戏！";
        }
        if (arr.length == 1) {
            return "只有一张牌，先手玩家赢，得分为：" + arr[0];
        }
        int f = f(arr, 0, arr.length - 1);
        int l = l(arr, 0, arr.length - 1);
        String winner = f > l ? "先手玩家赢，分数为：" + f : "后手玩家赢，分数为：" + l;
        return winner;
    }

    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int l1 = l(arr, L + 1, R);
        int l2 = l(arr, L, R - 1);
        return Math.max(l1 + arr[L], l2 + arr[R]);
    }

    public static int l(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int f1 = f(arr, L + 1, R);
        int f2 = f(arr, L, R - 1);
        return Math.min(f1 , f2 );
    }

    public static void main(String[] args) {
        int[] arr = {1,4,1};
        String win = getWin(arr);
        System.out.println(win);

    }
}
