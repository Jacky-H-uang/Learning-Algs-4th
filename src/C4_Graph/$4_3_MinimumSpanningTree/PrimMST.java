package C4_Graph.$4_3_MinimumSpanningTree;
import edu.princeton.cs.algs4.*;

/**
 * 最小生成树的 Prim 算法 (即时版本)
 */

public class PrimMST
{
    private Edge[] edgeTo;              // 距离树最近的边
    private double[] distTo;            // distTo[w] = edgeTo[w].weight()
    private boolean[] marked;           // 如果 v 在树中则为 true
    private IndexMinPQ<Double> pq;      // 有效的横切边

    private void visit(EdgeWeightedGraph G,int v)
    {
        marked[v] = true;

        // 访问点 v 所连接的所有的边,并找到其中权重最小的边
        for(Edge e : G.adj(v))
        {
            int w = e.other(v);

            // 表示 v - w 已经连接
            if(marked[w])       continue;

            if(e.weight() < distTo[w])
            {
                edgeTo[w] = e;              // 记录更近的边
                distTo[w] = e.weight();     // 记录更近的边的权值

                if(pq.contains(w))          // 如果这条边已经存在，就更新它的最短的距离
                {
                    pq.change(w,distTo[w]);
                }
                else                        // 如果这条边不存在就加入到队列中
                {
                    pq.insert(w,distTo[w]);
                }
            }
        }
    }

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];

        // 首先将每个点所连接边的最小距离初始化为 ： POSITIVE_INFINITY (正无穷大)
        for(int v = 0; v < G.V(); ++v)
        {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        pq = new IndexMinPQ<>(G.V());

        // 初始化 0 点所连接边的最短距离假设为 0
        distTo[0] = 0.0;
        pq.insert(0,0.0);

        while (!pq.isEmpty())
        {
            // 将最近的顶点添加到树中
            visit(G,pq.delMin());
        }
    }
}