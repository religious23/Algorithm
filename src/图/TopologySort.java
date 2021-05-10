package 图;

import java.util.*;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: TopologySort
 * @description: 拓扑排序
 * @date 2021-03-16
 */
public class TopologySort {

    public static List<Node> sortedTopology(Graph graph) {
        Map<Node, Integer> inMap = new HashMap<>();
        LinkedList<Node> zeroInQueue = new LinkedList<>();

        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        //拓扑排序的结果，依次加入result
        ArrayList<Node> result = new ArrayList<>();

        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next,inMap.get(next)-1);
                if(inMap.get(next)==0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
