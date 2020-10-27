package C3_Searching.Sequential_Searching;


//基于无序链表的
public class SequentialSearchST<Key,Value>
{
    private class Node
    {
        Key key;
        Value val;
        Node next;
        public Node(Key key,Value val,Node next)
        {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private Node first;

    public Value get(Key key)                               // Find the given key and return the associated value
    {
        for(Node x = first;x != null;x = x.next)
        {
            if(key.equals(x.key))
            {
                return x.val;                               // Bingo!
            }
        }
        return null;                                        // Not Bingo!
    }

    public void put(Key key,Value val)
    {
        for(Node x = first;x != null;x = x.next)
        {
            if(key.equals(x.key))                           // Hit update
            {
                x.val = val;
                return;
            }
        }
        first = new Node(key,val,first);                    // Miss new node
    }
}
