package C5_String.$5_3_SubstringSearching;

/**
 * Knuth-Morris-Pratt 字符串查找算法
 * (重要的字符串匹配算法)
 */


public class KMP
{
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        // 由模式字符串构造 DFA
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;

        // 构造 DFA           (X -- 表示从起状态)
        for(int X = 0,j = 1; j < M; ++j)
        {
            // 计算 dfa[][j]
            for(int c = 0; c < R; ++c)  dfa[c][j] = dfa[c][X];                  // 复制匹配失败情况下的值
            dfa[pat.charAt(j)][j] = j+1;                                        // 设置匹配成功情况下的值
            X = dfa[pat.charAt(j)][X];                                          // 更新重启状态
        }
    }

    public int search(String txt) {
        // 在 txt 上模拟 DFA 的运行
        int i , j;                      // j 表示 DFA 中的状态数，当 j 终状态的时候就发现其匹配
        int N = txt.length();
        int M = pat.length();
        for(i = 0,j = 0; i < N && j < M; ++i)
        {
            j = dfa[txt.charAt(i)][j];
        }
        if(j == M)      return i-M;                 // 找到匹配   (达到模式字符串的末尾)
        else            return  N;                  // 未找到匹配 (达到文本字符串的末尾)
    }
}