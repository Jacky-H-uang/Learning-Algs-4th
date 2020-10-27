package C4_Graph.$4_1_UndirectedGraph;


/**
 * 双色问题：
 * 能够用两种颜色将图的所有顶点着色，使得任意一条边的两个端点的颜色都不相同吗？
 * 这个问题等价于：这是一副二分图吗？
 */

public class TwoColors
{
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    private void dfs(Graph G,int v) {
        marked[v] = true;
        for(int w : G.adj(v))
        {
            if(!marked[w])
            {
                color[w] = !color[v];
                dfs(G,w);
            }
            else if(color[w] == color[v])           // 这个点访问过且 连接边的两个端点颜色都相同的时候就返回 false
            {
                isTwoColorable =false;
            }
        }
    }

    public TwoColors(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for(int s = 0; s < G.V(); ++s)
        {
            if(!marked[s])
            {
                dfs(G,s);
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}