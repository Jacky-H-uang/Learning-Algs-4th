package C4_Graph.$4_3_MinimumSpanningTree;
import edu.princeton.cs.algs4.*;

/**
 * 加权无向图的数据类型
 */


public class EdgeWeightedGraph
{
    private final int V;            // 顶点的总数
    private int E;                  // 边的总数
    private Bag<Edge>[] adj;        // 邻接表

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for(int v = 0; v < V; ++v)
        {
            adj[v] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    // 返回点 v 所连接边的邻接表
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    // 返回加权无向图中的所有边
    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for(int v = 0; v < V; ++v)
        {
            for(Edge e : adj[v])
            {
                if(e.other(v) > v)      b.add(e);
            }
        }

        return b;
    }
}