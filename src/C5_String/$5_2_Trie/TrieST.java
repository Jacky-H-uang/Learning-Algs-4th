package C5_String.$5_2_Trie;
import edu.princeton.cs.algs4.*;


/**
 * 基于单词查找树的符号表
 * @param <Value>
 */


public class TrieST<Value>
{
    private static int R = 256;         // 基数
    private Node root;                  // 单词查找树的根节点
    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }



    /**
     * 返回以 x 作为根节点的子单词查找树中与 key 相关联的值
     */
     private Node get(Node x,String key,int d) {
        if(x == null)           return null;
        if(d == key.length())   return x;

        // 找到第 d 个字符所对应的子单词查找树
        char c = key.charAt(d);

        return get(x.next[c],key,d+1);
    }
    public Value get(String key) {
        Node x = get(root,key,0);
        if(x == null)       return null;
        return (Value) x.val;
    }



    /**
     * 如果 key 存在于以 x 为根节点的子单词查找树中则更新与它相关联的值
     */
    private Node put(Node x,String key,Value val,int d) {
        if(x == null)           x = new Node();
        if(d == key.length())   { x.val = val; return x; }

        // 找到第 d 个字符所对应的子单词查找树
        char c = key.charAt(d);
        x.next[c] = put(x.next[c],key,val,d+1);
        return x;
    }
    public void put(String key,Value val) {
        root = put(root,key,val,0);
    }




    /**
     * 收集一棵单词查找树中所有的键
     */
    private void collect(Node x, String pre, Queue<String> q) {
        if(x == null)       return;
        if(x.val != null)   q.enqueue(pre);         // 遍历至此如果是个单词就加入队列
        for(char c = 0; c < R; ++c)
        {
            collect(x.next[c],pre+c,q);
        }
    }
    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<>();

        // 可以先调用 get() 找出给定前缀所对应的单词查找树
        collect(get(root,pre,0),pre,q);

        return q;
    }
    public Iterable<String> keys() {
        // 返回一个存储了所有单词的一个队列
        return keysWithPrefix("");
    }




    /**
     * 单词查找树中的通配符的匹配
     */
    private void collect(Node x,String pre,String pat,Queue<String> q) {
        int d = pre.length();
        if(x == null)                           return;
        if(d == pat.length() && x.val != null)  q.enqueue(pre);
        if(d == pat.length())                   return;

        char next = pat.charAt(d);
        for(char c = 0; c < R; ++c)
        {
            if(next == '.' || next == c)
            {
                collect(x.next[c],pre + c,pat,q);
            }
        }
    }
    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<>();
        collect(root, "",pat,q);
        return q;
    }


    /**
     * 对给定字符的最长前缀进行匹配
     */
    private int search(Node x,String s,int d,int length) {
        if(x == null)           return length;
        if(x.val != null)       length = d;
        if(d == s.length())     return length;

        char c = s.charAt(d);
        return search(x.next[c],s,d+1,length);
    }
    public String longestPrefixOF(String s) {
        int length = search(root,s,0,0);
        return s.substring(0,length);
    }




    /**
     * 从单词查找树中删除一个键（和它相关联的值）
     */
    private Node delete(Node x,String key,int d) {
        if(x == null)           return null;
        if(d == key.length())   x.val = null;
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c],key,d+1);
        }
        if(x.val != null)       return x;

        for (char c = 0; c < R; ++c)
        {
            if(x.next[c] != null)       return x;
        }

        return null;
    }
    public void delete(String key) {
        root = delete(root,key,0);
    }
}