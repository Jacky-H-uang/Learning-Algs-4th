package C1_Basic.Experiment_UnionFind;

/**
 * This is a improved API
 * quick-union
 */


public class quick_union {
    private int[] id;                               //分量 id (以触点作为索引)
    private int count;                              //分量数量
    private int find(int p)                         //找出 p或q 的根节点
    {
        while (p!=id[p]) p = id[p];
        return id[p];
    }

    public quick_union(int N)                       //初始化分量 id 数组
    {
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++)
        {
            id[i] = i;
        }
    }
    public void union(int p,int q)                  //将 p 和 q 的根节点归并到一起
    {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)  return;
        id[pRoot] = qRoot;
        count--;
    }
    public boolean connected(int p,int q)           //判断两个节点是否在一棵树上
    {
        return find(p) == find(q);
    }
    public int count()
    {
        return count;
    }
}
