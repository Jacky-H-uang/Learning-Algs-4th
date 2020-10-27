package C1_Basic.TimeCounter;


/**
 * This Program is to count how many tuples built by three numbers,which the sum of the is zero.
 * @version JDK-14
 * @author Jacky
 */

public class ThreeSum {
    public static int count(int[] a)
    {
        int N = a.length;
        int cnt = 0;
        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                for(int k=j+1;k<N;k++)
                {
                    if(a[i] + a[j] + a[k] == 0)
                    {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
