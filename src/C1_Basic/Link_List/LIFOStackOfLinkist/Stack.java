package C1_Basic.Link_List.LIFOStackOfLinkist;
import java.util.Iterator;

/**
 * This prgram is implementing Stack by Link-List
 * @version JDK-14
 * @author Jacky
 */

public class Stack<Item> implements Iterable<Item>
{
    private Node first;
    private int N;
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

    public boolean isEmpty()
    {
        return first == null;
    }
    public int size()
    {
        return N;
    }
    public void push(Item item)             //Java自带的垃圾处理会处理掉孤儿
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
}
