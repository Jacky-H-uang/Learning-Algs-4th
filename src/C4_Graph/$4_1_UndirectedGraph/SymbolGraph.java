package C4_Graph.$4_1_UndirectedGraph;
import edu.princeton.cs.algs4.*;

/**
 * 符号图
 */


public class SymbolGraph
{
    private ST<String,Integer> st;          // 符号名  --》 索引
    private String[] keys;                  // 索引   --》  符号名
    private Graph G;                        // 图

    public SymbolGraph(String stream,String sp) {
        st = new ST<>();

    }
}