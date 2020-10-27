package C1_Basic.Experiment_UnionFind;

/**
 * 加权的 quick_union Algorithm
 * 将大树连接到小树上
 */

public class union_find {
    private int[] id;                   //父链接数组 （由触点索引）
    private int[] sz;                   //（由触点索引的）各个根节点所对应的分量的大小
    private int count;                  //连通分量的数量

    public union_find(int N)
    {
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++)
        {
            id[i] = i;
        }
        sz = new int[N];
        for (int i=0;i<N;i++)
        {
            sz[i] = 1;
        }
    }
    public int getCount()
    {
        return count;
    }
    public int find(int p)                  //find 根节点
    {
        while(p!=id[p])     p=id[p];
        return p;
    }
    public boolean connected(int p,int q)
    {
        return find(p) == find(q);
    }
    public void union(int p,int q)          //将小数的根节点链接到大树上面
    {
        int i = find(p);
        int j = find(q);
        if(i==j)    return;
        if(sz[i] < sz[j])
        {
            id[i] = j;
            sz[j] += sz[i];
        }
        else
        {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}
