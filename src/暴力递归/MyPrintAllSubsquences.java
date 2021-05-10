package 暴力递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: MyPrintAllSubsquences
 * @description: 自己写的实现字符串的所有子串
 * @date 2021-03-26
 */
public class MyPrintAllSubsquences {
    public static List<String> subs(String str){
        char[] chars = str.toCharArray();
        String path="";
        ArrayList<String> list = new ArrayList<>();
        process(chars,0,path,list);
        return list;
    }

    private static void process(char[] chars, int i, String path, ArrayList<String> list) {
        if(i==chars.length){
            list.add(path);
            return;
        }

        String no=path;
        process(chars,i+1,no,list);

        String yes=path+chars[i]+"";
        process(chars,i+1,yes,list);
    }

    public static void main(String[] args) {
        String s="wangwen";
        List<String> subs = subs(s);
        System.out.println(subs);

    }
}
