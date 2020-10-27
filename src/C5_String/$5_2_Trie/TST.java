package C5_String.$5_2_Trie;

/**
 * 基于三向单词查找树的符号表
 * 一个字符有三个方向 left(小于字符)  mid(等于字符)  right(大于字符)
 */



public class TST<Value>
{
    private Node root;          // 树的根节点
    private class Node {
        char c;                 // 字符
        Node left,mid,right;    // 左中右子三向查找树
        Value val;              // 和字符串相关联的值
    }



    /**
     * 返回以 x 作为根节点的子单词查找树中与 key 相关联的值
     */
    private Node get(Node x,String key,int d) {
        if(x == null)       return null;

        char c = key.charAt(d);
        if(c < x.c)                 return get(x.left,key,d);
        else if(c > x.c)            return get(x.right,key,d);
        else if(d < key.length()-1) return get(x.mid, key,d+1);
        else                        return x;
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
        char c = key.charAt(d);

        if(x == null)                   { x = new Node(); x.c = c; }
        if(c < x.c)                     x.left = put(x.left,key,val,d);
        else if(c > x.c)                x.right = put(x.right,key,val,d);
        else if(d < key.length()-1)     x.mid = put(x.mid,key,val,d+1);
        else                            x.val = val;

        return x;
    }
    public void put(String key,Value val) {
        root = put(root,key,val,0);
    }
}