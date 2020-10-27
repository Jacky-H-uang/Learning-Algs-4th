package C4_Graph.$4_2_Digraph;


/**
 * 计算强连通分量的 Kosaraju 算法
 * 强连通 : v 和 w 可以相互可达，则 v 和 w 称为强连通
 *
 * 解决问题：给定一幅有向图，回答 “给定的两个点是强连通吗？”这幅有向图中含有多少个强连通分量
 */


public class KosarajuSCC
{
    private boolean[] marked;           // 已访问过的顶点
    private int[] id;                   // 强连通分量的表示符
    private int count;                  // 强连通分量的数量

    private void dfs(Digraph G,int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v))
        {
            if(!marked[v])
            {
                dfs(G,w);
            }
        }
    }

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G);
        for(int s : order.reversePost())
        {
            if(!marked[s])
            {
                dfs(G,s);
                count++;
            }
        }
    }

    public boolean stronglyConnected(int v,int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }
}