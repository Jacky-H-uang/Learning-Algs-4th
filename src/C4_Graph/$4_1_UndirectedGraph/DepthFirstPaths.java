package C4_Graph.$4_1_UndirectedGraph;

import C1_Basic.Link_List.LIFOStackOfLinkist.Stack;

/**
 * 解决单点路径：判断从一个点到另一个点是否存在一条路径
 */

public class DepthFirstPaths
{
    private boolean[] marked;           // 判断这个顶点上调用过 dfs() 了吗？
    private int[] edgeTo;               // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;                // 起点

    private void dfs(Graph G,int v) {
        marked[v] = true;
        for(int w : G.adj(v))
        {
            if(!marked[w])
            {
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }

    public DepthFirstPaths(Graph G,int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }


    // 返回能否到达节点 v
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // 打印到达节点 v 的栈轨迹
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v))       return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x = edgeTo[x])
        {
            path.push(x);
        }
        path.push(s);

        return path;
    }
}
