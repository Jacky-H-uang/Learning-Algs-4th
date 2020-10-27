package C5_String.$5_1_StringSorting;

/**
 * Least-Significant-Digit First  -- 低位优先的字符串排序算法
 * 该算法是稳定的，可以稳定的将字符串排序
 */

// 从低位开始向高位来排序
public class LSD
{
    public static void sort(String[] a,int W) {
        // 通过前 W 个字符将 a[] 排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        // 根据第 d 个字符用键索引计数法排序
        for(int d = W - 1; d >= 0; d--)
        {
            // 计算出现频率
            int[] count = new int[R+1];
            for(int i = 0; i < N; ++i)
            {
                // charAt() 方法字符转为字符串中的索引
                count[a[i].charAt(d) + 1]++;
            }

            // 将频率转化为索引
            for(int r = 0; r < N; ++r)
            {
                count[r+1] += count[r];
            }

            // 将元素分类 (用辅助数组记录这次排序的结果)
            for(int i = 0; i < N; ++i)
            {
                // 注意每次记录索引的时候都要往后移一位，方便之后的记录
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            // 回写
            for(int i = 0; i < N; ++i)
            {
                a[i] = aux[i];
            }
        }
    }
}