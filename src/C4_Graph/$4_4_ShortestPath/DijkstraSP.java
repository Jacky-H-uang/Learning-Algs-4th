package C4_Graph.$4_4_ShortestPath;
import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * 最短路径的 Dijkstra 算法
 */


public class DijkstraSP
{
    private DirectedEdge[] edgeTo;
    private double[] disTo;
    private IndexMinPQ<Double> pq;

    private void relax(EdgeWeightedDigraph G,int v) {
        for(DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if(disTo[w] > disTo[v] + e.weight())
            {
                // 更新到 w 的最短距离的值
                disTo[w] = disTo[v] + e.weight();
                edgeTo[w] = e;

                // 如果队列中已经存在了这条边就更新这条边 否则就插入这条边
                if(pq.contains(w))
                {
                    pq.change(w,disTo[w]);
                }
                else
                {
                    pq.insert(w,disTo[w]);
                }
            }
        }
    }

    public DijkstraSP(EdgeWeightedDigraph G,int s) {
        edgeTo = new DirectedEdge[G.V()];
        disTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());

        // 每个点的边都初始化为无穷大
        for(int v = 0; v < G.V(); ++v)
        {
            disTo[v] = Double.POSITIVE_INFINITY;
        }

        disTo[s] = 0.0;

        pq.insert(s,0.0);

        while(!pq.isEmpty())
        {
            relax(G,pq.delMin());
        }
    }
}