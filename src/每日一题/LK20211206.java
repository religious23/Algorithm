package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211206
 * @description: 截断句子
 * @date 2021-12-06
 */
public class LK20211206 {
    public String truncateSentence(String s, int k) {
        String[] split = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < k - 1; i++) {
            buffer.append(split[i]).append(" ");
        }
        buffer.append(split[k-1]);
        return buffer.toString();
    }
}
