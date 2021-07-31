package 常见题目;

/**
 * @author 王文
 * @version : V1.0
 * @className: BracketProblem
 * @description: 括号问题四连
 * @date 2021-07-31
 */

import java.util.Arrays;

/**
 * 括号有效配对是指：
 * （1）任何一个左括号都能找到和其正确配对的右括号
 * （2）任何一个右括号都能找到和其正确配对的左括号
 * <p>
 * 问题1：怎么判断一个括号字符串有效
 * 问题2：如果一个括号字符串无效，返回至少几个字符能让其整体有效
 * 问题3：求一个括号字符串最长的括号有效字串的长度
 * 问题4：有效的字符串中，最大的嵌套层数
 */

public class BracketProblem {

    /**
     * @return boolean
     * @Author 王文
     * @Description 问题1
     * @Date 2021/7/31
     * @Param [str]
     **/
    public boolean getQuestionOne(String str) {
        char[] chars = str.toCharArray();
        int num = 0;
        for (char s : chars) {
            if (s == '(') {
                num++;
            } else {
                num--;
                if (num < 0) {
                    return false;
                }
            }
        }
        return num == 0;
    }

    /**
     * @return boolean
     * @Author 王文
     * @Description 问题2
     * @Date 2021/7/31
     * @Param [str]
     **/
    public int getQuestionTwo(String str) {
        char[] chars = str.toCharArray();
        int num = 0;
        int need = 0;
        for (char s : chars) {
            if (s == '(') {
                num++;
            } else {
                if (num == 0) {
                    need++;
                } else {
                    num--;
                }
            }
        }
        return need + num;
    }


    /**
     * @return int
     * @Author 王文
     * @Description 问题3
     * @Date 2021/7/31
     * @Param [str]
     **/
    public int getQuestionThree(String str) {
        char[] chars = str.toCharArray();
        int n = str.length();
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 1 - 1) < 0 ? 0 : dp[i - dp[i - 1] - 1 - 1]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    /**
     * @return boolean
     * @Author 王文
     * @Description 问题4
     * @Date 2021/7/31
     * @Param [str]
     **/
    public int getQuestionFour(String str) {
        char[] chars = str.toCharArray();
        int num = 0;
        int max = 0;
        for (char s : chars) {
            if (s == '(') {
                num++;
                max = Math.max(max, num);
            } else {
                num--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BracketProblem bracketProblem = new BracketProblem();
        String str = "((()))(())";
        System.out.println(bracketProblem.getQuestionOne(str));
        System.out.println(bracketProblem.getQuestionTwo(str));
        System.out.println(bracketProblem.getQuestionThree(str));
        System.out.println(bracketProblem.getQuestionFour(str));
    }
}
