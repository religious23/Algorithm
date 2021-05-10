package 图;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Graph
 * @description: 图中图结构的描述
 * @date 2021-03-14
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes=new HashMap<>();
        edges=new HashSet<>();
    }
}
