package C2_Sorting.Shell_Sorting;
import C2_Sorting.Example.Example;


//希尔排序得思想是使数组中任意间隔为h得元素都是有序的
public class Shell
{
    //a[] 按升序排序
    //使用序列 1/2(3^k-1), 从 N/3 开始递减至 1。
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;

        //时间复杂度为O(N^3/2)
        while(h<N/3)
        {
            h = 3*h+1;                              //1     4       13      40      121     364         1093    ······
        }
        while(h>=1)
        {
            for(int i=h;i<N;i++)
            {
                for(int j=i;j> h && Example.less(a[j],a[j-h]);j -= h)
                {
                    Example.exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }
}