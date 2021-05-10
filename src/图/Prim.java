package 图;

import java.util.*;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Prim
 * @description: 最小生成树 P算法
 * @date 2021-03-24
 */
public class Prim {
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {
        //解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Kruskal.EdgeComparator());

        //哪些点被解锁出来了
        HashSet<Node> nodeSet = new HashSet<>();

        Set<Edge> result = new HashSet<>(); //一次挑选的边在result里

        for (Node node : graph.nodes.values()) {
            //随便挑了一个点 作为开始点 node
            if (!nodeSet.contains(node)) {
                nodeSet.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll(); //弹出解锁的边中，最小的边
                    Node toNode = edge.to;//可能的一个新的点
                    if (!nodeSet.contains(toNode)) {
                        nodeSet.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }

    // 请保证graph是连通图
    // graph[i][j]表示点i到点j的距离，如果是系统最大值代表无路
    // 返回值是最小连通图的路径之和

}

