package 图;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Dijkstra
 * @description: 迭戈克斯拉问题
 * @date 2021-03-24
 */
public class Dijkstra {

    public static HashMap<Node, Integer> dijkstra1(Node from) {
        //从head出发到所有点的最小距离
        //key : 从head出发到达key
        //value :从head出发到达key的最小距离
        //如果在表中，没有T的记录，含义是从head出发到T点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);
        //已经求过距离的节点，存在selectedNodes中，以后也不再碰
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(
            HashMap<Node, Integer> distanceMap,
            HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MIN_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }


}
