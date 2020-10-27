package C4_Graph.$4_2_Digraph;

/**
 * 解决问题：
 * 1. 单点可达性问题：给定一副有向图和一个起点 s ，回答是否存在一条从 s 到达给定顶点 v 的有向路径
 * 2. 多点可达性问题：给定一副有向图和顶点的集合，回答是否存在一条从集合中任意顶点到达给定顶点 v 的有向路径
 */

public class DirectedDFS
{
    private boolean[] marked;

    // 采用 Integer 可迭代额数据输入，来表示一个点或者顶点的集合
    private void dfs(Digraph G,int v) {
        marked[v] = true;
        for(int w : G.adj(v))
        {
            if(!marked[w])
            {
                dfs(G,w);
            }
        }
    }

    public DirectedDFS(Digraph G,int s) {
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    public DirectedDFS(Digraph G,Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for(int s : sources)
        {
            if(!marked[s])
            {
                dfs(G,s);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }


}
