package C4_Graph.$4_4_ShortestPath;
import edu.princeton.cs.algs4.*;

/**
 * 加权有向图的数据结构
 */

public class EdgeWeightedDigraph
{
    private final int V;                    // 顶点的数目
    private int E;                          // 边的数目
    private Bag<DirectedEdge>[] adj;        // 边的权重

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];

        // 每个点都初始化一份邻接表
        for(int v = 0; v < V; ++v)
        {
            adj[v] = new Bag<>();
        }
    }

    public int E() {
        return E;
    }

    public int V() {
        return V;
    }


    public void addEdge(DirectedEdge e)
    {
        // 将这条边的起点的邻接表中添加入这条边
        adj[e.form()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for(int v = 0; v < V; ++v)
        {
            for(DirectedEdge e : adj[v])
            {
                bag.add(e);
            }
        }

        return bag;
    }
}