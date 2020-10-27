package C5_String.$5_1_StringSorting;
import edu.princeton.cs.algs4.*;

import static C2_Sorting.Example.Example.exch;


/**
 * Most-Significant-Digit First  -- 高位优先的字符串排序算法
 * 高位优先的字符串排序算法的性能取决于数据
 */


public class MSD
{
    private static int R = 256;             // 基数
    private static final int M = 15;        // 小数组的切换阈值
    private static String[] aux;            // 数据分类的辅助数组

    private static int charAt(String s, int d) {
        if(d < s.length())      return s.charAt(d);
        else                    return -1;
    }

    private static boolean less(String v,String w,int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private void sort(String[] a,int lo,int hi,int d) {
        // 以 d 个字符为键将 a[lo] 至 a[hi] 排序
        for(int i = 0; i <= hi; ++i)
        {
            for(int j = i; j > lo && less(a[j],a[j-1],d); j--)
            {
                exch(a,j,j-1);
            }
        }

        // 计算频率
        int[] count = new int[R+2];
        for(int i = lo; i <= hi; ++i)
        {
            count[charAt(a[i],d) + 2] ++;
        }

        // 将频率转换为索引
        for(int r = 0; r < R+1; ++r)
        {
            count[r+1] += count[r];
        }

        // 数据分类
        for(int i = lo; i <= hi; ++i)
        {
            aux[count[charAt(a[i],d)+1]++] = a[i];
        }

        // 回写
        for(int i = lo; i <= hi; ++i)
        {
            a[i] = aux[i-lo];
        }

        // 递归的以每个字符为键进行排序
        for(int r = 0; r < R; ++r)
        {
            sort(a,lo + count[r],lo + count[r+1]-1,d+1);
        }
    }

    public void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a,0,N-1,0);
    }
}