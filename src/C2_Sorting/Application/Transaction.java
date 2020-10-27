package C2_Sorting.Application;
import java.util.Comparator;
import edu.princeton.cs.algs4.*;

public class Transaction
{
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who,Date when,double amount)
    {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }
    private static boolean less(Comparator c,Object v,Object w)
    {
        return c.compare(v,w) < 0;
    }
    private static void exch(Object[] a,int i,int j)
    {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Object[] a,Comparator c)            //Comparator c 是一个比较器 可以为下面的三个类中的任意一个
    {
        int N = a.length;
        for(int i=1;i<N;i++)
        {
            for(int j=i;j>0 && less(c,a[j],a[j-1]);j--)
            {
                exch(a,j,j-1);
            }
        }
    }

    public static class WhonOrder implements Comparator<Transaction>
    {
        public int compare(Transaction v,Transaction w)
        {
            return v.who.compareTo(w.who);
        }
    }
    public static class WhenOrder implements Comparator<Transaction>
    {
        public int compare(Transaction v,Transaction w)
        {
            return v.when.compareTo(w.when);
        }
    }
    public static class HowMuchOrder implements Comparator<Transaction>
    {
        public int compare(Transaction v,Transaction w)
        {
            if(v.amount < w.amount)     return -1;
            if(v.amount > w.amount)     return +1;
            return 0;
        }
    }
}
