package 暴力递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: PrintAllSubsquences
 * @description: 生成一个字符串的所有字串
 * @date 2021-03-26
 */
public class PrintAllSubsquences {
    public static List<String> subs(String s){
        char[] str = s.toCharArray();
        String path="";
        ArrayList<String> ans = new ArrayList<>();
        process1(str,0,ans,path);
        return ans;
    }

    //str固定，不变
    //index此时来到的位置，要 or 不要
    public static void process1(char[] str,int index,List<String> ans,String path){
        if(index==str.length){
            ans.add(path);
            return;
        }
        String no=path;
        process1(str,index+1,ans,no);
        String yes=path+String.valueOf(str[index]);
        process1(str,index+1,ans,yes);
    }

    public static void main(String[] args) {
        String s="wangwen";
        List<String> subs = subs(s);
        System.out.println(subs);
    }
}
