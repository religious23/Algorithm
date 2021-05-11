package 图;



import java.util.ArrayList;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Node
 * @description: 图中点结构的描述
 * @date 2021-03-14
 */
public class Node {
    public Integer value;
    public Integer in;
    public Integer out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in=0;
        this.out=0;
        this.nexts=new ArrayList<>();
        this.edges=new ArrayList<>();
    }
}
