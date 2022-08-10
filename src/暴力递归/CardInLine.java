package 暴力递归;


/**
 * @author W.Wen
 * @version : V1.0
 * @className: CardInLine
 * @description: 两人对弈，拿两边的纸牌，返回获胜者分数
 * @date 2021-03-02
 */
public class CardInLine {

    public static int win(int[] cardArray) {
        if (cardArray.length == 0 || cardArray == null) {
            return 0;
        }
        int first = f(cardArray, 0, cardArray.length - 1);
        int last = l(cardArray, 0, cardArray.length - 1);
        if (first > last) {
            System.out.println("先手玩家赢");
        } else {
            System.out.println("后手玩家赢");
        }
        return Math.max(first, last);
    }

    private static int l(int[] cardArray, int l, int r) {
        if (l == r) {
            return cardArray[l];
        }
        int l1 = f(cardArray, l + 1, r);
        int l2 = f(cardArray, l, r - 1);
        return Math.min(l1, l2);
    }

    private static int f(int[] cardArray, int l, int r) {
        if (l == r) {
            return cardArray[l];
        }
        int f1 = cardArray[l] + l(cardArray, l + 1, r);
        int f2 = cardArray[r] + l(cardArray, l, r - 1);
        return Math.max(f1, f2);
    }

    public static void main(String[] args) {
        int[] cards1 = {10,7, 25,45, 24, 1};
        int win = win(cards1);
        System.out.println(win);
    }

}
