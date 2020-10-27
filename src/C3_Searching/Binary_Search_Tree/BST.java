package C3_Searching.Binary_Search_Tree;
import edu.princeton.cs.algs4.*;



// 基于二叉查找树的符号表
public class BST<Key extends Comparable<Key>,Value>
{
    private Node root;
    private class Node
    {
        private Key key;                    // 键
        private Value val;                  // 值
        private Node left,right;            // 指向子树的连接
        private int N;                      // 以该节点为根的子树中的结点的总数 （结点计数器）
        public Node(Key key,Value val,int N)
        {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    private int size(Node x)
    {
        if(x == null)       return 0;
        else                return x.N;
    }
    public int size()
    {
        return size(root);
    }



    // 二叉查找树的查找方法
    private Value get(Node x,Key key)
    {
        if(x == null)       return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)         return get(x.left,key);
        else if(cmp > 0)    return get(x.right,key);
        else                return x.val;
    }
    public Value get(Key key)
    {
        return get(root,key);
    }



    // 二叉查找树的排序方法
    private Node put(Node x,Key key,Value val)
    {
        if(x == null)       return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)         x.left = put(x.left,key,val);
        else if(cmp > 0)    x.right = put(x.right,key,val);
        else                x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void put(Key key,Value val)
    {
        root = put(root,key,val);
    }



    // 二叉查找树的最小元素
    private Node min(Node x)
    {
        if(x.left == null)      return x;
        return min(x.left);
    }
    public Key min()
    {
        return min(root).key;
    }


    // 二叉查找树的最大元素
    private Node max(Node x)
    {
        if(x.right == null)     return x;
        return max(x.right);
    }
    public Key max()
    {
        return max(root).key;
    }




    // 二叉树的向上取整的算法
    // 查找 <= key 的最大键
    private Node floor(Node x,Key key)
    {
        if(x == null)       return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)        return x;
        if(cmp < 0)         return floor(x.left,key);
        Node t = floor(x.right,key);
        if(t != null)       return t;
        else                return x;
    }
    public Key floor(Key key)
    {
        Node x = floor(root,key);
        if(x == null)       return null;
        return x.key;
    }



    // 二叉查找树的选择算法
    private Node select(Node x,int k)               // 返回排名 k 的结点
    {
        if(x == null)
        {
            return null;
        }
        int t = size(x.left);
        if(t > k)               return select(x.left,k);
        else if(t < k)          return select(x.right,k-t-1);
        else                    return x;
    }
    public Key select(int k)                        // 找出排名为 k 的键
    {
        return select(root,k).key;
    }




    // 二叉查找树的排名算法
    private int rank(Key key,Node x)                // 返回以 x 为根节点的子树中小于 x.key 的键的数量
    {
        if(x == null)
        {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0)             return rank(key,x.left);
        else if(cmp > 0)        return 1+size(x.left) + rank(key,x.right);
        else                    return size(x.left);
    }
    public int rank(Key key)
    {
        return rank(key,root);
    }



    // 二叉查找树的删除算法 之 (最小结点的删除算法)
    private Node deleteMin(Node x)
    {
        if(x.left == null)      return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void deletMin()
    {
        root = deleteMin(root);
    }



    // 二叉查找树的删除算法 之 （任意一个结点的删除算法)
    private Node delete(Node x,Key key)
    {
        if(x == null)           return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)             x.left = delete(x.left,key);
        else if(cmp > 0)        x.right = delete(x.right,key);
        else
        {
            if(x.right == null)         return x.left;
            if(x.left == null)          return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);               //------?
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key)
    {
        root = delete(root,key);
    }

    // 二叉查找树的范围查找操作
    private void keys(Node x, Queue<Key> queue,Key lo, Key hi)
    {
        if(x == null)       return;
        int cmplo = lo.compareTo(x.key);
        int comphi = hi.compareTo(x.key);
        if(cmplo < 0)                       keys(x.left,queue,lo,hi);
        if(cmplo <= 0 && comphi >=0)        queue.enqueue(x.key);
        if(comphi > 0)                      keys(x.right,queue,lo,hi);
    }
    public Iterable<Key> keys(Key lo,Key hi)
    {
        Queue<Key> queue = new Queue<>();
        keys(root,queue,lo,hi);
        return queue;
    }
    // 返回的是一个队列 按中序遍历排序的队列
    public Iterable<Key> keys()
    {
        return keys(min(),max());
    }
}