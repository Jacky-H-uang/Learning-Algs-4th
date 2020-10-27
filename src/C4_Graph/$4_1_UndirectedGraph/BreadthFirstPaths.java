package C4_Graph.$4_1_UndirectedGraph;
import C1_Basic.Link_List.LIFOStackOfLinkist.Stack;
import C1_Basic.Link_List.Queue.Queue;


/**
 * BFS 广度优先搜索 --(利用队列来进行操作)
 */


public class BreadthFirstPaths
{
    private boolean[] marked;               // 到达该顶点的最短路径已知吗？
    private int[] edgeTo;                   // 到达该顶点已知路径上的最后一个顶点
    private final int s;                    // 起点

    private void bfs(Graph G,int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;                   // 标记起点
        queue.enqueue(s);                   // 将起点加入队列
        while(!queue.isEmpty()) {
            int v = queue.dequeue();
            for(int w : G.adj(v))
            {
                if(!marked[w])              // 对于每个未被标记的相邻顶点
                {
                    edgeTo[w] = v;          // 保存最短路径的最后一条边
                    marked[w] = true;       // 标记它，因为最短路径已知
                    queue.enqueue(w);       // 并将它加入到队列中
                }
            }
        }
    }

    public BreadthFirstPaths(Graph G,int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;

        bfs(G,s);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v))       return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v;x != s; x = edgeTo[x])
        {
            path.push(x);
        }
        path.push(s);

        return path;
    }
}
