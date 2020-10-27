package C1_Basic.Experiment_UnionFind;

/**
 * This is a API
 * @version JDK-14
 * @author Jacky
 *
 *                              Union-Find 算法的 API
 * public class UF
 *      UF(int N)                               以整数标识 (0 ~ N-1) 初始化 N 个触点
 *      void union(int p,int q)                 在 p 和 q之间添加一条连接
 *      int find(int p)                         p (0 ~ N-1) 所在的分量的标识符
 *      boolean connected(int p,int q)          如果 p 和 q 存在于同一个分量中则返回 true
 *      int count()                             连通分量的数量
 */

public class UF
{
    private int[] id;                       //分量 id (以触点作为索引)
    private int count;                      //分量数量

    public UF(int N)                       //初始化分量 id 数组
    {
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++)
        {
            id[i] = i;
        }
    }

    public void union(int p,int q)          //将 p 和 q 归并到相同的分量中
    {
        int pID = find(p);
        int qID = find(q);
        if(pID == qID)                      //如果 p 和 q 已经在相同的分量中则不需要采取任何行动
        {
            return;
        }
        for(int i=0;i<id.length;i++)
        {
            if(id[i] == pID)                //将 p 的分量重命为 q 的名称
            {
                id[i] = qID;
            }
            count--;
        }
    }

    // id 映射
    public int find(int p)
    {
        return id[p];
    }

    public boolean connected(int p,int q)
    {
        return find(p) == find(q);
    }

    public int count()
    {
        return count;
    }
}
