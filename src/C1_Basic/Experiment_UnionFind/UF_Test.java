package C1_Basic.Experiment_UnionFind;

import edu.princeton.cs.algs4.*;

public class UF_Test {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(p == -1 && q == -1)
            {
                break;
            }
            if(uf.connected(p,q))
            {
                continue;
            }
            uf.union(p,q);
            StdOut.println(p + "    " + q);
        }
        StdOut.println(uf.count() + "components");
    }
}
