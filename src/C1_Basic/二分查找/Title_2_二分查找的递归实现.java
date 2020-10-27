package C1_Basic.二分查找;

//二分查找的递归实现

public class Title_2_二分查找的递归实现 {
    public static int rank(int key,int[] a)
    {
        return rank(key,a,0,a.length-1);
    }
    public static int rank(int key,int[] a,int lo,int hi)
    {
        if(lo > hi)
            return -1;
        int mid = lo + (hi-lo)/2;
        if(key < a[mid])
            return rank(key,a,lo,mid-1);
        else if(key > a[mid])
            return rank(key,a,mid+1,hi);
        else
            return mid;
    }

    public static void main(String[] args)
    {
        int k = 3;
        int[] a = new int[]{1,2,3,4,5,6};
        int rr = rank(k,a);
        System.out.println(rr);
    }
};
