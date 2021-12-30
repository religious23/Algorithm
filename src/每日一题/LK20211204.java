package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211204
 * @description: 赎金信
 * @date 2021-12-04
 */
public class LK20211204 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] res = new int[26];
        boolean flag = true;
        for (char c : ransomNote.toCharArray()) {
            res[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            res[c - 'a']--;
        }
        for (int re : res) {
            if (re > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }
}
