package C4_Graph.$4_1_UndirectedGraph;
import edu.princeton.cs.algs4.*;


/**
 * 这份 Graph 的实现使用了一个由顶点索引的整型链表数组
 */
public class Graph
{
    private final int V;            // 顶点数目
    private int E;                  // 边的数目
    private Bag<Integer>[] adj;     // 邻接表 --(利用背包实现的邻接表)

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];      // 创建邻接表
        for(int v = 0; v <V; ++v)
        {
            adj[v] = new Bag<Integer>();        // 每个节点都创建一个邻接表
        }
    }

    public Graph(In in) {
        this(in.readInt());         // 读取 V 并将图初始化
        int E = in.readInt();       // 读取 E
        for(int i = 0; i < E; ++i)
        {
            // 添加一条边
            int v = in.readInt();   // 读取一个顶点   
            int w = in.readInt();   // 读取另个顶点
            addEdge(v,w);           // 添加一条连接它们的边
        }
    }

    public int V() { return V; }
    public int E() { return E; }

    // 双向添加 (因为是无向图)
    public void addEdge(int v,int w) {
        adj[v].add(w);              // 将 w 添加到 v 的链表中
        adj[w].add(v);              // 将 v 添加到 w 的链表中
        E++;
    }

    // 返回与 v 相邻的所有顶点 --(是一个 Bag 集合)
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = V + " vertoces , " + E + " edges\n";
        for(int v = 0; v < v; ++v)
        {
            s += v + " : ";
            for(int w : this.adj(v))
            {
                s += w + " ";
            }
            s += "\n";
        }

        return s;
    }


}
