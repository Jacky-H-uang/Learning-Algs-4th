package C4_Graph.$4_3_MinimumSpanningTree;


/**
 * 带权重边的数据类型
 */

public class Edge
{
    private final int v;               // 顶点之一
    private final int w;               // 另一个顶点
    private final double weight;       // 边的权重

    public Edge(int v, int w,double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    // 可以访问这条边上的两个点
    public int either() {
        return v;
    }

    // 已知一个点，访问另一个点
    public int other(int vertex) {
        if(vertex == v)         return w;
        else if(vertex == w)    return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    public int compareTo(Edge that) {
        if(this.weight() < that.weight())        return -1;
        else if(this.weight() > that.weight())   return 1;
        else                                     return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f",v,w,weight);
    }
}