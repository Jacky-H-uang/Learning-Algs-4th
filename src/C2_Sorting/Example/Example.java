package C2_Sorting.Example;
import edu.princeton.cs.algs4.*;

/**
 * This is a example program for sorting
 * @version JDK-14
 * @author Jacky
 */


//Notes: Comparable 排序接口 ， 实现了 Comparable 接口意味着支持排序
//       在创建自己的数据时，只要实现 Comparable 接口就可以排序
public class Example {
    private static void show(Comparable[] a)
    {
        for(int i=0;i<a.length;i++)
        {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean less(Comparable v,Comparable w)              // less 对元素进行比较
    {
        return v.compareTo(w) <0;
    }
    public static void exch(Comparable[] a,int i,int j)               // exch 将元素交换位置
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void sort(Comparable[] a)
    {
        /**
         * Many Sorting Algorithms
         */
    }
    public static boolean isSorted(Comparable[] a)
    {
        for(int i=1;i<a.length;i++)
        {
            if(less(a[i],a[i-1]))   return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);                                         //断言一定为真的 否则就抛出异常
        show(a);
    }
}
