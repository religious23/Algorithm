package 每日一题;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211124
 * @description: 从英文中重建数字
 * @date 2021-11-24
 */
public class Lk20211124 {
    public String originalDigits(String s) {
        char[] chars = s.toCharArray();
        int[] ints = new int[26];
        int[] res = new int[10];
        StringBuffer buffer = new StringBuffer();
        for (char aChar : chars) {
            ints[aChar - 'a']++;
        }
        res[0] = ints['z' - 'a'];
        res[1] = ints['o' - 'a'] - ints['z' - 'a'] - ints['u' - 'a'] - ints['w' - 'a'];
        res[2] = ints['w' - 'a'];
        res[3] = ints['r' - 'a'] - ints['z' - 'a'] - ints['u' - 'a'];
        res[4] = ints['u' - 'a'];
        res[5] = ints['v' - 'a'] - ints['s' - 'a'] + ints['x' - 'a'];
        res[6] = ints['x' - 'a'];
        res[7] = ints['s' - 'a'] - ints['x' - 'a'];
        res[8] = ints['t' - 'a'] - ints['w' - 'a'] - ints['r' - 'a'] + ints['z' - 'a'] + ints['u' - 'a'];
        res[9] = (ints['n' - 'a'] - ints['s' - 'a'] + ints['x' - 'a'] - ints['o' - 'a'] + ints['z' - 'a'] + ints['u' - 'a'] + ints['w' - 'a']) / 2;
        for (int i = 0; i < res.length; i++) {
            while (res[i] != 0) {
                buffer.append(i);
                res[i]--;
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Lk20211124 lk20211124 = new Lk20211124();
        System.out.println(lk20211124.originalDigits("fviefuro"));
    }
}
