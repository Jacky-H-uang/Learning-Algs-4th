package C1_Basic.二分查找;
//二分查找的非递归的实现

import java.util.Arrays;
public class Title_3_二分查找的非递归实现 {
    public static int rank(int key,int[] a)
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

    public static void main(String[] args)
    {
        int[] whiteList = new int[]{1,2,5,1,2,4,8,0,2,3};
        Arrays.sort(whiteList);
        int rr = rank(1,whiteList);
        System.out.println(rr);
    }
}

