package C4_Graph.$4_1_UndirectedGraph;


/**
 * 检测环问题：
 * 给定的图是无环图吗？
 */


public class Cycle
{
    private boolean[] marked;
    private boolean hasCycle;

    private void dfs(Graph G,int v,int u) {
        marked[v] = true;
        for(int w : G.adj(v))
        {
            if(!marked[w])
            {
                dfs(G,w,v);
            }
            else if(w != u)             // w 访问过且 w != u 的时候说明此时有环
            {
                hasCycle = true;
            }
        }
    }

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for(int s = 0; s < G.V(); ++s)
        {
            if(!marked[s])
            {
                dfs(G,s,s);
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}