package 每日一题;

import java.util.HashMap;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211117
 * @description: 最大单词长度乘积
 * @date 2021-11-17
 */
public class LK20211117 {
    public int maxProduct(String[] words) {
        int res = 0;
        HashMap<String, int[]> map = new HashMap<>();
        for (String word : words) {
            int[] arr = new int[26];
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                arr[aChar - 'a'] = 1;
            }
            map.put(word, arr);
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int[] a1 = map.get(words[i]);
                int[] a2 = map.get(words[j]);
                boolean decide = decide(a1, a2);
                if (decide) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public boolean decide(int[] a1, int[] a2) {
        boolean res = true;
        for (int i = 0; i < a1.length; i++) {
            if ((a1[i] & a2[i]) == 1) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        LK20211117 lk20211117 = new LK20211117();
        System.out.println(lk20211117.maxProduct(words));
    }
}
