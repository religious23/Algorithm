package 暴力递归;


/**
 * @author W.Wen
 * @version : V1.0
 * @className: ConvertTOletterString
 * @description: 从左往右尝试模型  数字转字母
 * @date 2021-03-26
 */
public class ConvertToLetterString {
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    //str[0...i-1]已经转化完了,固定了
    //i之前的位置，如何转化已经做了决定了，不用再关心
    //i... 有多少种转化的结果
    private static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        //str[i]字符不是'0'
        if (str[i] == '1') {
            int res = process(str, i + 1); //i自己作为单独的部分，后续有多少种方法
            if (i + 1 < str.length) {
                res += process(str, i + 2);//(i和i+1) 作为单独的部分，后续有多少种方法
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1);//i自己作为单独的部分，后续有多少种方法
            //(i和i+1) 作为单独的部分并且没有超过26，后续有多少种方法
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str,i+1);
    }

    public static void main(String[] args) {
        int number = number("1214");
        System.out.println(number);

    }
}
