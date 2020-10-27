package C4_Graph.$4_3_MinimumSpanningTree;
import edu.princeton.cs.algs4.*;

/**
 * 最小生成树的 Kruskal 算法
 */


public class KruskalMST
{
    // 优先队列保存最短距离的边
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();

        for(Edge e : G.edges())
        {
            pq.insert(e);
        }

        // 声明一个 UF 数据结构
        UF uf = new UF(G.V());

        while(!pq.isEmpty() && mst.size() < G.V()-1)
        {
            // 从 pq 得到权重最小的边和它的顶点
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);

            if(uf.connected(v,w))           // 忽略失效的边
            {
                continue;
            }

            uf.union(v,w);                  // 合并分量
            mst.enqueue(e);                 // 将边添加到最小生成树中
        }
    }

    public Iterable<Edge> edges()
    {
        return mst;
    }
}