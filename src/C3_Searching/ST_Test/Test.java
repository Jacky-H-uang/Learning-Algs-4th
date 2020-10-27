package C3_Searching.ST_Test;

import edu.princeton.cs.algs4.*;

public class Test {
    public static void main(String[] args)
    {
        ST<String,Integer> st;
        st = new ST<>();
        for(int i=0;!StdIn.isEmpty();i++)
        {
            String key = StdIn.readString();
            st.put(key,i);
        }
        for (String s:st.keys())
        {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
