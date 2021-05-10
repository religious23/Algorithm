package 暴力递归;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.ArrayList;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: PrintAllPermutations
 * @description: 打印全排列
 * @date 2021-03-26
 */
public class PrintAllPermutations {
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process1(chs, 0, res);
        return res;
    }

    public static void process1(char[] str, int i, ArrayList<String> ans) {
        if (i == str.length) {
            ans.add(String.valueOf(str));
            return;
        }
        //如果i没有终止，i... 都可以来到i位置
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            process1(str, i + 1, ans);
            swap(str, i, j);
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        String s = "wangwen";
        ArrayList<String> list = permutation(s);
        System.out.println(list);
    }


    //分支限界 去除重复 杀死支路
    public static void process2(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(str + "");
            return;
        }
        boolean[] booleans = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!booleans[str[j] - 'a']) {
                booleans[str[j] - 'a'] = true;
                swap(str, i, j);
                process2(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }

}
