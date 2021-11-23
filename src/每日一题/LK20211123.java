package 每日一题;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211123
 * @description: 亲密字符串
 * @date 2021-11-23
 */
public class LK20211123 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        boolean res = false;
        char[] s1 = s.toCharArray();
        char[] g1 = goal.toCharArray();
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s1[i] != g1[i]) {
                list1.add(s1[i]);
                list2.add(g1[i]);
            }
            set.add(s1[i]);
        }
        if (list1.size() == 2) {
            res = list1.get(0) == list2.get(1) && list1.get(1) == list2.get(0);
        } else if (list1.size() == 0) {
            res = set.size() != s1.length;
        }
        return res;
    }
}
