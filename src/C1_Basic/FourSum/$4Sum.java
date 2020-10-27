package C1_Basic.FourSum;
import edu.princeton.cs.algs4.*;

import java.util.Arrays;


/**
 * This is a program to calculate the sum of 4 elements in the Array
 * @version JDK-14
 * @author Jacky
 */

public class $4Sum {
    public static int binarySearch(int key,int[] a)
    {
        int lo = 0;
        int hi = a.length-1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(key<a[mid]) hi = mid-1;
            else if(key>a[mid]) lo = mid+1;
            else return mid;
        }
        return -1;
    }
    public static int count(int[] a)
    {
        Arrays.sort(a);
        int len = a.length;
        int ct = 0;
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                for(int k=j+1;k<len;k++)
                {
                    if(binarySearch(-(a[i]+a[j]+a[k]),a) > k)
                    {
                        ct++;
                    }
                }
            }
        }
        return ct;
    }


    public static void main(String[] args)
    {
        int[] num = new int[]{0,0,0,0};
        int r = $4Sum.count(num);
        System.out.println(r);
    }
}
