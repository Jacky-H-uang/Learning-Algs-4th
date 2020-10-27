package C3_Searching.Binary_Searching;

/*
* Notes：（递归的 rank() 函数）
*
* public int rank(Key key,int lo,int hi)
*   {
*       if(hi < lo)     return lo;
*       int mid = lo + (hi-lo)/2;
*       int cmp = key.compareTo(keys[mid]);
*       if(cmp < 0)         return rank(key,lo,mid-1);
*       else if(cmp > 0)    return rank(key,mid+1,hi);
*       else                return mid;
*   }
*
*/


// 基于有序数组（迭代）
//（使用的数据结构是一对平行的数组 ， 一个存储键 一个存储值）
public class BinarySearchingST<Key extends Comparable<Key>,Value>
{
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchingST(int capacity)
    {
        keys = (Key[]) new Comparable[capacity];            //存储键
        vals = (Value[]) new Object[capacity];              //存储值
    }
    public int size()
    {
        return N;
    }
    public boolean isEmpty()
    {
        return size() == 0;
    }
    public int rank(Key key)
    {
        int lo = 0;
        int hi = N-1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0)             hi = mid-1;
            else if(cmp > 0)        lo = mid+1;
            else                    return mid;
        }
        return lo;
    }

    public Value get(Key key)
    {
        if(isEmpty())           return null;
        int i = rank(key);
        if(i<N && keys[i].compareTo(key) == 0)      return vals[i];
        else                                        return null;
    }
    public void put(Key key,Value val)
    {
        int i = rank(key);
        if(i<N && keys[i].compareTo(key)==0)
        {
            vals[i] = val;                        // Hit Update
            return;
        }
        for(int j=N;j>i;j--)
        {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
}