package C3_Searching.Red_Black_Search_Tree;

public class RedBlackBST<Key extends Comparable<Key>,Value>
{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private class Node
    {
        Key key;                    // 键
        Value val;                  // 相关联的值
        Node left,right;            // 左右子树
        int N;                      // 这颗子树中的结点总数
        boolean color;              // 由其父节点指向它的链接的颜色

        Node(Key key,Value val,int N,boolean color)
        {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    // 测试一个结点和它父结点的链接
    private boolean isRed(Node x)
    {
        if(x == null)       return false;
        return x.color == RED;
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

    // 左旋转
    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+ size(h.left) + size(h.right);
        return x;
    }

    // 右旋转
    private Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    // 颜色转换
    private void flipColors(Node h)
    {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // 查找 key ， 找到则更新其值，否则为它创建一个新结点
    private Node put(Node h,Key key,Value val)
    {
        if(h == null)
        {
            return new Node(key,val,1,RED);
        }
        int cmp = key.compareTo(h.key);
        if(cmp < 0)             h.left = put(h.left,key,val);
        else if(cmp > 0)        h.right = put(h.right,key,val);
        else                    h.val = val;

        if(isRed(h.right) && !isRed(h.left))            h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))         h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right))             flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
    public void put(Key key,Value val)
    {
        root = put(root,key,val);
        root.color = BLACK;
    }

    //
    // 其他操作与二叉搜索树一样，可以归并到一起，形成完整的 API
}
