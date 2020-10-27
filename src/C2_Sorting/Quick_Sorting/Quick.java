package C2_Sorting.Quick_Sorting;
import edu.princeton.cs.algs4.*;

import static C2_Sorting.Example.Example.exch;
import static C2_Sorting.Example.Example.less;

public class Quick
{
    //将数组切分为 a[lo...i-1] , a[i] , a[i+1...hi]
    private static int partition(Comparable[] a,int lo,int hi)
    {
        int i = lo;                                     //左扫描指针
        int j = hi+1;                                   //右扫描指针
        Comparable v = a[lo];                           //切分元素
        while (true)                                    //扫描左右元素是否结束并交换元素
        {
            while(less(a[++i],v))
            {
                if(i == hi)
                {
                    break;
                }
            }
            while (less(v,a[--j]))
            {
                if(j == lo)
                {
                    break;
                }
            }
            if(i>=j)
            {
                break;
            }
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }


    private static void sort(Comparable[] a,int lo,int hi)
    {
        if(hi <= lo)                return;
        int j = partition(a,lo,hi);                     //切分
        sort(a,lo,j-1);                             //将左半部分 a[lo...j-1]排序
        sort(a,j+1,hi);                             //将右半部分 a[j+1...hi]排序
    }


    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);                           // 消除对数组输入的依赖
        sort(a,0,a.length-1);
    }
}
