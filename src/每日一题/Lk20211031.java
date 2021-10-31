package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Lk20211031
 * @description: 键盘行
 * @date 2021-10-31
 */
public class Lk20211031 {

    public static String[] findWords(String[] words) {
        int[] map={2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> strings = new ArrayList<String>();
        for (String word : words) {
            int res=0;
            char[] chars = word.toLowerCase().toCharArray();
            boolean flag=true;
            for (char aChar : chars) {
                if(res!=0&&res!=map[aChar-97]){
                    flag=false;
                    break;
                }
                res=map[aChar-97];
            }
            if(flag){
                strings.add(word);
            }
        }
        return strings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] words={"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }

}
