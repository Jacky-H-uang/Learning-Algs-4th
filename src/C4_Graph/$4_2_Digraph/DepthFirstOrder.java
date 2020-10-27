package C4_Graph.$4_2_Digraph;
import edu.princeton.cs.algs4.*;


/**
 * 基于深度优先搜索的顶点排序
 * (只有无环图才能进行顶点排序)
 */


public class DepthFirstOrder
{
    private boolean[] marked;
    private Queue<Integer> pre;             // 所有顶点的前序排列 : 递归调用前将顶点加入队列
    private Queue<Integer> post;            // 所有顶点的后序排列 : 递归调用之后将顶点加入队列
    private Stack<Integer> reversePost;     // 所有顶点的逆后序排列 : 递归调用之后将顶点压入栈

    private void dfs(Digraph G,int v) {
        pre.enqueue(v);
        marked[v] = true;
        for(int w : G.adj(v))
        {
            if(!marked[v])
            {
                dfs(G,w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public DepthFirstOrder(Digraph G) {
        // 初始化
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];

        for(int v = 0; v < G.V(); ++v)
        {
            if(!marked[v])      dfs(G,v);
        }
    }
}
