package C1_Basic.Link_List.BagImpements;


import java.util.Iterator;

/**
 * This Program is implementing Bag by Link-List
 * @version JDK-14
 * @author Jacky
 */

// Bag is also Last In First Out
// Because Bag can not take the values out so it doesn't exit pop() function
public class Bag<Item> implements Iterable<Item>
{

    private class Node
    {
        Item item;
        Node next;
    }
    private Node fitst;
    private int N;
    private class ListIterator implements Iterator<Item>
    {
        private Node current = fitst;
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

    public Iterator<Item> iterator()                //迭代器
    {
        return new ListIterator();
    }
    public boolean isEmpty()
    {
        return fitst == null;
    }
    public int size()
    {
        return N;
    }
    public void add(Item item)
    {
        Node oldfirst = fitst;
        fitst = new Node();
        fitst.item = item;
        oldfirst.next = fitst;
        N++;
    }

}
