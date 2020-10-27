package C4_Graph.$4_2_Digraph;
import edu.princeton.cs.algs4.*;

/**
 * 此算法基于深度优先搜索来寻找有向环
 */

public class DirectedCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;           // 有向环中所有的顶点
    private boolean[] onStack;              // 递归调用的栈上的所有顶点

    private void dfs(Digraph G,int v) {
        onStack[v] = true;
        marked[v] = true;
        for(int w : G.adj(v))
        {
            // 栈不为空的时候直接返回 （证明此时有环在栈中）
            if(this.hasCycle())     return;
            else if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G,w);
            }
            else if (onStack[w])
            {
                cycle = new Stack<>();
                for(int x = v; x != w; x = edgeTo[x])
                {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    // 返回有向环中的所有顶点
    public Iterable<Integer> cycle() {
        return cycle;
    }

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];

        for(int v = 0; v < G.V(); ++v)
        {
            if(!marked[v])  dfs(G,v);
        }
    }
}
