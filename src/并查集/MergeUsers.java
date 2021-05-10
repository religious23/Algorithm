package 并查集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: MergeUsers
 * @description: 并查集合并用户
 * @date 2021-03-14
 */
public class MergeUsers {

    public static class User {
        private String a;
        private String b;
        private String c;

        public User(String a,String b,String c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }


    public static int mergeUsers(List<User> users) {
        UnionFind.UnionSet<User> unionFind = new UnionFind.UnionSet<User>(users);
        HashMap<String, User> map1 = new HashMap<>();
        HashMap<String, User> map2 = new HashMap<>();
        HashMap<String, User> map3 = new HashMap<>();

        for (User user : users) {
            if (map1.containsKey(user.a)){
                unionFind.union(user,map1.get(user.a));
            }else{
                map1.put(user.a,user);
            }
            if (map2.containsKey(user.b)){
                unionFind.union(user,map2.get(user.b));
            }else{
                map2.put(user.b,user);
            }
            if (map3.containsKey(user.c)){
                unionFind.union(user,map3.get(user.c));
            }else{
                map3.put(user.c,user);
            }
        }
        return unionFind.sizeMap.size();
    }

    public static void main(String[] args) {
        User user1 = new User("1", "4", "2");
        User user2 = new User("2", "1", "2");
        User user3 = new User("3", "4", "1");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        System.out.println(mergeUsers(users));


    }
}
