package 每日一题;

import java.util.*;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211022
 * @description: 给定一个大小为n的整数数组，找出其中出现超过n/3次的元素
 * @date 2021-10-22
 */
public class LK20211022 {
    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else if (map.size() == 2) {
                Iterator<Integer> iterator = map.keySet().iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    map.put(integer, map.get(integer) - 1);
                    if (map.get(integer) == 0) {
                        iterator.remove();
                    }
                }
            } else {
                map.put(num, 1);
            }
        }
        int[] ints = new int[2];
        Set<Integer> set = map.keySet();
        int k = 0;
        for (Integer integer : set) {
            ints[k] = integer;
            k++;
        }
        for (int num : nums) {
            if (num == ints[0]) {
                i++;
            }
            if (k==2&&num == ints[1]) {
                j++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (i > (nums.length / 3)) {
            list.add(ints[0]);
        }
        if (k==2&&j > (nums.length / 3)) {
            list.add(ints[1]);
        }
        return list;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2,3};
        System.out.println(majorityElement(arr));
    }
}
