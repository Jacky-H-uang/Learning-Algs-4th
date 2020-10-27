package C2_Sorting.Priority_Queue;
import edu.princeton.cs.algs4.*;

//使用队列的多项归并
public class Multiway
{
    public static void merge(In[] streams)
    {
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<>(N);

        for(int i=0;i<N;i++)
        {
            if(!streams[i].isEmpty())
            {
                pq.insert(i,streams[i].readString());
            }
        }
        while (!pq.isEmpty())
        {
            StdOut.print(pq.minKey()+"  ");
            int i = pq.delMin();
            if(!streams[i].isEmpty())
            {
                pq.insert(i,streams[i].readString());
            }
        }
    }

    public static void main(String[] args)
    {
        int N = args.length;
        In[] streams = new In[N];
        for(int i=0;i<N;i++)
        {
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }
}
