package C2_Sorting.Merge_Sorting;
import static C2_Sorting.Example.Example.less;

//自底向上 排序
public class MergeBU {
    private static Comparable[] aux;            //归并所需的辅助数组


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
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1;sz < N;sz = sz+sz)                               //sz 子数组的大小
        {
            for(int lo = 0;lo < N-sz;lo += sz+sz)                       //lo 子数组的索引
            {
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
    }
}
