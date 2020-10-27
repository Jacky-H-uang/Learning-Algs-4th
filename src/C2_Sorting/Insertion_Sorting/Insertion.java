package C2_Sorting.Insertion_Sorting;
import C2_Sorting.Example.Example;


//插入排序所需的时间取决于输入中元素的初始顺序。
//例如：对一个很大且其中的元素已经有序（或接近有序）的数组进行排序将会比对随机顺序的数组或是逆序数组进行排序要快得多
public class Insertion
{
    //按 a[] 的升序排序
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i=1;i<N;i++)
        {
            for(int j=i;j>0 && Example.less(a[j],a[j-1]);j--)
            {
                Example.exch(a,j,j-1);
            }
        }
    }
}