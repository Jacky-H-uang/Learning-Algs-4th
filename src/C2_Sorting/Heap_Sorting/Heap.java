package C2_Sorting.Heap_Sorting;

public class Heap
{
    private Heap() { }
    private static boolean less(Comparable[] pq, int i, int j)              //堆的比较元素
    {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
    private static void exch(Object[] pq, int i, int j)                     //堆的交换元素
    {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
    private static void sink(Comparable[] pq, int k, int n)
    {
        while (2*k <= n)
        {
            int j = 2*k;
            if (j < n && less(pq, j, j+1))      j++;
            if (!less(pq, k, j))                   break;
            exch(pq, k, j);
            k = j;
        }
    }



    public static void sort(Comparable[] a)
    {
        int N = a.length;

        //先构造堆
        for(int k = N/2;k >= 1;k--)
        {
            sink(a,k,N);
        }

        //然后排序
        while (N > 1)
        {
            exch(a,1,N--);
            sink(a,1,N);
        }
    }
}
