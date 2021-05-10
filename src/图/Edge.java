package 图;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Edge
 * @description: 图中边结构的描述
 * @date 2021-03-14
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
