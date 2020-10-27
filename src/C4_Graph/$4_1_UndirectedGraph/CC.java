package C4_Graph.$4_1_UndirectedGraph;


/**
 * 连通分量 (Union-Find算法)
 */

public class CC
{
    private boolean[] marked;           // 寻找一个顶点作为每个连通分量中深度优先搜索的起点
    private int[] id;
    private int count;

    private void dfs(Graph G,int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v))
        {
            if(!marked[w])
            {
                dfs(G,w);
            }
        }
    }

    // 判断两个点是否连通
    public boolean conected(int v,int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int s = 0; s < G.V(); ++s)
        {
            if(!marked[s])
            {
                dfs(G,s);
                count++;
            }
        }
    }
}
