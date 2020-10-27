package C4_Graph.$4_3_MinimumSpanningTree;
import edu.princeton.cs.algs4.*;

import java.awt.*;

/**
 * 最小生成树 Prim 算法的延时实现
 */


public class LazzyPrimMST
{
    private boolean[] marked;           // 最小生成树的顶点
    private Queue<Edge> mst;            // 最小生成树的边
    private MinPQ<Edge> pq;             // 横切边 (包括失效的边)

    private void visit(EdgeWeightedGraph G,int v) {
        // 标记顶点 v 并将所有连接 v 和未标记顶点的边加入 pq
        for(Edge e : G.adj(v))
        {
            if(!marked[e.other(v)])     pq.insert(e);
        }
    }

    public LazzyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();

        // 假设 G 是连通的, 将第一个点所连接的所有边加入到 pq 中
        visit(G,0);

        while(!pq.isEmpty())
        {
            Edge e = pq.delMin();                   // 从 pq 中得到权重最小的边

            // 得到最小权值边所连接的两个顶点
            int v = e.either();
            int w = e.other(v);

            if(marked[v] && marked[w])  continue;   // 若两个顶点所连接的这条边已经访问了，跳过失效的边
            mst.enqueue(e);                         // 将边添加到树中

            // 如果被访问的点所连接的所有边没有被添加到树中的时候将其都添加到树中
            if(!marked[v])      visit(G,v);
            if(!marked[w])      visit(G,w);

        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}