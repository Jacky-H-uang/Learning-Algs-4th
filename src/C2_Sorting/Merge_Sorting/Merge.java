package C2_Sorting.Merge_Sorting;
import edu.princeton.cs.algs4.*;
import static C2_Sorting.Example.Example.less;

/**
 * This is a program for Merge Sorting
 * @version JDK-14
 * @author Jacky
 */

//自顶向下的归并排序
public class Merge
{
    private static Comparable[] aux;                //归并所需要的辅助数组
    private static void sort(Comparable[] a,int lo,int hi)
    {
        if(hi<=lo)      return;
        int mid = lo+(hi-lo)/2;
        sort(a,lo,mid);                            //左排序
        sort(a,mid+1,hi);                      //右排序
        merge(a,lo,mid,hi);
    }

    //原地归并的抽象方法 ---》 连个已经排序好的数组
    public static void merge(Comparable[] a,int lo,int mid,int hi)
    {
        int i = lo;
        int j = mid+1;
        for(int k=lo;k<hi;k++)
        {
            aux[k] = a[k];
        }
        for(int k=lo;k<=hi;k++)
        {
            if(i>mid)                       a[k] = aux[j++];            //左边用完 全部取 右边
            else if(j>hi)                   a[k] = aux[i++];            //右边用完 全部取 左边
            else if(less(aux[j],aux[i]))    a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }
    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
}
