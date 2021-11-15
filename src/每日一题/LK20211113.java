package 每日一题;

import javax.swing.plaf.metal.MetalIconFactory;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211113
 * @description: 检测大写字母
 * @date 2021-11-15
 */
public class LK20211113 {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        boolean res;
        if (word.toCharArray()[0] - 'A' < 26) {
            if (word.toCharArray()[1] - 'A' < 26) {
                res = this.decide(word, 1);
            } else {
                res = this.decide(word, 2);
            }
        } else if (word.toCharArray()[1] - 'A' < 26) {
            res = false;
        } else {
            res = this.decide(word, 3);
        }
        return res;
    }

    public boolean decide(String word, int kind) {
        boolean res = true;
        if (kind == 1) {
            for (int i = 2; i < word.length(); i++) {
                if (word.toCharArray()[i] - 'A' >= 26) {
                    res = false;
                    break;
                }
            }
        } else if (kind == 2) {
            for (int i = 2; i < word.length(); i++) {
                if (word.toCharArray()[i] - 'A' < 26) {
                    res = false;
                    break;
                }
            }
        } else {
            for (int i = 2; i < word.length(); i++) {
                if (word.toCharArray()[i] - 'A' < 26) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String word="USJe";
        LK20211113 lk20211113 = new LK20211113();
        System.out.println(lk20211113.detectCapitalUse(word));
    }
}
