package 动态规划;

import java.util.HashMap;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: StickersToSpellword
 * @description: 贴纸拼凑字符串
 * @date 2021-04-03
 */
public class StickersToSpellWord {
    public static void main(String[] args) {

    }

    public static int minStickers1(String[] stickers, String target) {
        int n = stickers.length;
        int[][] map = new int[n][26];
        HashMap<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                map[i][c - 'a']++;
            }
        }
        return process1(dp, map, target);
    }

    // dp 傻缓存，如果t已经算过了，直接返回dp中的值
    //t 剩余的目标
    //0..N每一个字符串所含字符的词频统计
    //返回值是-1，map 中的贴纸，怎么都无法rest
    private static int process1(HashMap<String, Integer> dp, int[][] map, String t) {
        if (dp.containsKey(t)) {
            return dp.get(t);
        }
        int ans = Integer.MAX_VALUE;
        int n = map.length;
        int[] tmap = new int[26];
        char[] target = t.toCharArray();
        for (char c : target) {
            tmap[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            //枚举当前第一张贴纸是谁？
            if (map[i][target[0] - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            //i贴纸，j枚举 a--z字符
            for (int j = 0; j < 26; j++) {
                if (tmap[j] > 0) {
                    for (int k = 0; k < Math.max(0, tmap[j] - map[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            //剩下的字符都存在sb中了
            String s = sb.toString();
            int tmp = process1(dp, map, s);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        dp.put(t, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(t);
    }
}
