package C4_Graph.$4_4_ShortestPath;
import edu.princeton.cs.algs4.*;

/**
 * 基于队列的 Bellman-Ford 算法
 */


public class BellmanFordSP
{
    private double[] distTo;                    // 从起点到某个顶点的路径长度
    private DirectedEdge[] edgeTo;              // 从起点到某个顶点的最后一条边
    private boolean[] onQ;                      // 该顶点是否存在于队列中
    private Queue<Integer> queue;               // 正在被放松的顶点
    private int cost;                           // relax() 的调用次数
    private Iterable<DirectedEdge> cycle;       // edgeTo[] 中是否有负权重环


    // 负权重环检测方法 (未定义)
    private void findNegativeCycle() {

    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    private void relax(EdgeWeightedDigraph G,int v) {
        for(DirectedEdge e : G.adj(v))
        {
            int w =e.to();
            if(distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if(!onQ[w])
                {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if(cost ++ % G.V() == 0)
            {
                findNegativeCycle();
            }
        }
    }

    public BellmanFordSP(EdgeWeightedDigraph G,int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for(int v = 0; v < G.V(); ++v)
        {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        onQ[s] = true;
        while(!queue.isEmpty() && !hasNegativeCycle())
        {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G,v);
        }
    }
}