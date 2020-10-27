package C4_Graph.$4_2_Digraph;
import edu.princeton.cs.algs4.*;

public class Digraph
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = E;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; ++v)
        {
            adj[v] = new Bag<>();
        }
    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(int v,int w) {
        adj[v].add(w);
        E++;
    }

    // 返回可迭代的 Bag
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // 将有向图的方向反向
    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for(int v = 0; v < V; ++v)
        {
            for(int w : adj(v))
            {
                R.addEdge(w,v);
            }
        }
        return R;
    }
}