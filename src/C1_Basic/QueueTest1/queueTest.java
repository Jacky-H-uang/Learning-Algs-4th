package C1_Basic.QueueTest1;

import C1_Basic.Link_List.Queue.Queue;
import edu.princeton.cs.algs4.*;

public class queueTest {
    public static int[] readInts(String name)
    {
        In in = new In(name);
        C1_Basic.Link_List.Queue.Queue<Integer> q = new Queue<Integer>();
        while (!in.isEmpty())
        {
            q.enqueue(in.readInt());
        }
        int N = q.size();
        int []a = new int[N];
        for(int i=0;i<N;i++)
        {
            a[i] = q.dequeue();
        }
        return a;
    }
}
