package 图;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: BFS
 * @description: 图的宽度优先遍历
 * @date 2021-03-15
 */

/**
 * 自己的理解 利用队列 依此将改层的节点拿出
 */
public class BFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
