package C1_Basic.Link_List.Queue;
import java.util.Iterator;                  //引用 JAVA 的 Iterator 接口

public class Queue<Item> implements Iterable<Item>
{
    private class Node
    {
        Item item;
        Node next;
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        {
            return current != null;
        }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    private Node first;                 //Queue head Node
    private Node last;                  //Queue tail Node
    private int N;                      //Queue's size


    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public int size()
    {
        return N;
    }
    public void enqueue(Item item)              //Add values from tail
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())
        {
            first = last;
        }
        else
        {
            oldlast.next = last;
        }
        N++;
    }
    public Item dequeue()                       //Delete values from head
    {
        Item item = first.item;
        first = first.next;
        if(isEmpty())
        {
            last = null;
        }
        N--;
        return item;
    }
}
