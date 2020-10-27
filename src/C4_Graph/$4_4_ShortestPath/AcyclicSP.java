package C4_Graph.$4_4_ShortestPath;
import C4_Graph.$4_2_Digraph.Topological;

/**
 * 无环加权有向图的最短距离算法 （最优的算法）
 */


public class AcyclicSP
{
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    // 顶点松弛
    private void relax(EdgeWeightedDigraph G, int v) {
        for(DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if(distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public AcyclicSP(EdgeWeightedDigraph G,int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for(int v = 0; v < G.V(); ++v)
        {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;
        Topological top = new Topological(G);

        for (int v : top.order())
        {
            relax(G,v);
        }
    }
}