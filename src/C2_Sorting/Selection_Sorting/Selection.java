package C2_Sorting.Selection_Sorting;
import C2_Sorting.Example.Example;                      //import Sorting template

//运行时间与输入无关
//时间复杂度为 O(N^2)
public class Selection
{
    //按 a[] 的升序排序
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i=0;i<N;i++)
        {
            int min = i;
            for(int j=i+1;j<N;j++)
            {
                if(Example.less(a[j],a[i]))     min = j;
            }
            Example.exch(a,i,min);                      //将 a[i] 与 a[min] 换位置
        }
    }
}