package 哈希表和有序表;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 王文
 * @date 2020/12/21 15:24
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class HashMapAndSortedMap {
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"我是1");
        map.put(2,"我是2");
        map.put(3,"我是3");
        map.put(4,"我是4");
        map.put(5,"我是5");
        map.put(6,"我是6");
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(10));

        System.out.println(map.get(4));
        System.out.println(map.get(10));

        map.put(4,"他是4");
        System.out.println(map.get(4));
        map.remove(4);
        System.out.println(map.get(4));

        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.contains("abc");
        set.remove("abc");

        //哈希表增删改查 在使用时 时间复杂度都是o(1)

        System.out.println("===================");
    }
}
