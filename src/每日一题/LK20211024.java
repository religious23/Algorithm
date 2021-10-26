package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211024
 * @description: 大礼包 (有一些小问题，之后处理)
 * @date 2021-10-24
 */
public class LK20211024 {
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = price.size();
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        for (List<Integer> sp : special) {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; ++i) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }
        special = filterSpecial;
        return process(price, special, needs, 0, map);
    }

    private static int process(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int money, HashMap<String, Integer> map) {

        if (map.containsKey(string(needs))) {
            return map.get(string(needs));
        }

        boolean flag = true;
        for (Integer need : needs) {
            if (need != 0) {
                flag = false;
                break;
            }
        }

        if (flag) {
            return money;
        }
        int res = Integer.MAX_VALUE;
        int n = price.size();

        if (special.size() == 0) {
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> list1 = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    list1.add(j, needs.get(j));
                }
                if (needs.get(i) > 0) {
                    list1.set(i, needs.get(i) - 1);
                    res = Math.min(process(price, special, list1, money + price.get(i), map), res);
                }
            }
        } else {
            for (List<Integer> integers : special) {
                boolean bool = true;
                ArrayList<Integer> list = new ArrayList<>(n);

                for (int i = 0; i < n; i++) {
                    list.add(i, needs.get(i));
                }

                for (int i = 0; i < n; i++) {
                    if (integers.get(i) > needs.get(i)) {
                        bool = false;
                        break;
                    } else {
                        list.set(i, needs.get(i) - integers.get(i));
                    }
                }
                if (bool) {
                    res = Math.min(process(price, special, list, money + integers.get(n), map), res);
                }

                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> list1 = new ArrayList<>(n);
                    for (int j = 0; j < n; j++) {
                        list1.add(j, needs.get(j));
                    }
                    if (needs.get(i) > 0) {
                        list1.set(i, needs.get(i) - 1);
                        res = Math.min(process(price, special, list1, money + price.get(i), map), res);
                    }
                }
            }
        }
        map.put(string(needs), res);
        //System.out.println(res);
        return res;
    }

    private static String string(List<Integer> needs) {
        String res = "";
        for (Integer need : needs) {
            res = "_" + need;
        }
        return res;
    }


    public static void main(String[] args) {
        ArrayList<Integer> price = new ArrayList<>();
        ArrayList<List<Integer>> special = new ArrayList<>();
        ArrayList<Integer> special2 = new ArrayList<>();
        ArrayList<Integer> special3 = new ArrayList<>();
        ArrayList<Integer> needs = new ArrayList<>();
        price.add(0, 0);
        price.add(1, 0);
        price.add(2, 0);
        special2.add(0, 1);
        special2.add(1, 1);
        special2.add(2, 0);
        special2.add(3, 4);
        special3.add(0, 2);
        special3.add(1, 2);
        special3.add(2, 1);
        special3.add(3, 9);
        special.add(0, special2);
        special.add(1, special3);
        needs.add(0, 2);
        needs.add(1, 2);
        needs.add(2, 1);
        System.out.println(shoppingOffers(price, special, needs));
    }
}
