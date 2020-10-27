package C2_Sorting.Priority_Queue;
import static C2_Sorting.Example.Example.less;

/**
 * This is an API of PQ
 * @version JDK-14
 * @author Jacky
 */

public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;                               //基于堆的完全二叉树
    private int N = 0;                              //存储于 pq[1..N] 中，在 pq[0] 没有使用

    private boolean less(int i,int j)               //堆的比较方法
    {
        return pq[i].compareTo(pq[j])< 0;
    }

    private void exch(int i,int j)                  //堆的交换方法
    {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 当某个结点的优先级上升（或是在堆底加入一个新的元素时），我们需要由下至上恢复堆的顺序
     * 当某个结点的优先级下降（例如，将根结点替换为一个较小的元素）时，我们需要由上至下恢复堆的顺序
     */
    private void swim(int k)                    //由下至上的堆有序化（上浮）的实现
    {
        while (k > 1 && less(k/2,k))
        {
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k)                    //由上至下的堆有序化（下沉）的实现
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if(j < N && less(j,j+1))    j++;
            if(!less(k,j))                 break;
            exch(k,j);
            k = j;
        }
    }



    public MaxPQ(int maxN)                      //数组从 1 开始
    {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void insert(Key v)
    {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax()
    {
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }
}
