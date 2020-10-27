package C2_Sorting.Quick_Sorting;
import edu.princeton.cs.algs4.StdRandom;
import static C2_Sorting.Example.Example.less;
import static C2_Sorting.Example.Example.exch;

// 三向切分的快速排序
public class Quick3way
{
    private static void sort(Comparable[] a,int lo,int hi)
    {
        if(hi<=lo)              return;
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        Comparable v = a[lo];
        while(i <= gt)
        {
            int cmp = a[i].compareTo(v);

            if(cmp < 0)         exch(a,lt++,i++);
            else if(cmp > 0)    exch(a,i,gt--);
            else                i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }


    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);                           // 消除对数组输入的依赖
        sort(a,0,a.length-1);
    }
}
