package 常见题目;

import java.util.ArrayList;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LCSubString
 * @description: 求两个字符串的最长公共子串   (加强版 不止一个)
 * @date 2021-10-19
 */
public class LCSubString {
    public static ArrayList<String> getString(String str1, String str2) {
        ArrayList<String> list = new ArrayList<>();
        if (str1.length() == 0 || str2.length() == 0) {
            return list;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int row = 0;
        int col = s2.length - 1;
        int resMax = 0;
        int resEnd = 0;
        while (row < s1.length) {
            int end = 0;
            int max = 0;
            int i = row;
            int j = col;
            while (i < s1.length && j < s2.length) {
                if (s1[i] == s2[j]) {
                    max++;
                    end = i;
                }
                i++;
                j++;
            }
            if (resMax != 0 && resMax == max) {
                resEnd = end;
                list.add(str1.substring(resEnd - resMax + 1, resEnd + 1));
            } else if (resMax < max) {
                resMax = max;
                resEnd = end;
                list.clear();
                list.add(str1.substring(resEnd - resMax + 1, resEnd + 1));
            }
            if (col == 0) {
                row++;
            } else {
                col--;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        String str1 = "5424";
        String str2 = "5424312314213gfgtrd";
        System.out.println(getString(str1, str2));
    }
}
