package C3_Searching.ST_Test;
import edu.princeton.cs.algs4.*;

//计算出 出现频率最高的单词的数量
public class FrequencyCounter {
    public static void main(String[] args)
    {
        int minLen = Integer.parseInt(args[0]);
        ST<String,Integer> st = new ST<>();
        while (!StdIn.isEmpty())
        {
            String word = StdIn.readString();
            if(word.length() < minLen)      continue;
            if(!st.contains(word))          st.put(word,1);
            else                            st.put(word,st.get(word)+1);
        }
        String max = "";
        st.put(max,0);
        for(String word : st.keys())
        {
            if(st.get(word) > st.get(max))
            {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }
}
