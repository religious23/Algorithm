package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20220107
 * @description: 括号的最大嵌套深度
 * @date 2022-01-07
 */
public class Lk20220107 {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        int max = 0;
        for (char s1 : chars) {
            if (s1 == '(') {
                num++;
                max = Math.max(max, num);
            } else if (s1 == ')') {
                num--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Lk20220107 lk20220107 = new Lk20220107();
        System.out.println(lk20220107.maxDepth("(1)+((2))+(((3)))"));
    }
}
