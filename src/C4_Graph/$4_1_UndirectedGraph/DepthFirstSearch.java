package C4_Graph.$4_1_UndirectedGraph;

/**
 * 图的深度优先搜索 DFS (使用下压栈)
 * 用来检查图的连通性
 */

public class DepthFirstSearch
{
    private boolean[] marked;           // 标记数组 --(标记那些元素搜索过)
    private int count;

    private void dfs(Graph G,int v) {
        marked[v] = true;
        count++;
        for(int w : G.adj(v))
        {
            if(!marked[w])  dfs(G,w);
        }
    }

    public DepthFirstSearch(Graph G,int s) {
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    public int count() {
        return count;
    }
}