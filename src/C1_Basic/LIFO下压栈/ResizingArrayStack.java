package C1_Basic.LIFO下压栈;
import java.util.Iterator;

/**
 * @param <Item>    This is a complete program for Stack
 * @version JDK-14
 * @author Jacky
 */

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for(int i=0;i<N;i++)
        {
            temp[i] = a[i];
        }
        a = temp;
    }
    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;
        public boolean hasNext()
        {
            return i>0;
        }
        public Item next()
        {
            return a[--i];
        }
        public void remove() { }
    }

    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    public Item pop()
    {
        Item item = a[--N];
        a[N] = null;
        if(N>0 && N==a.length/4)
        {
            resize(a.length/2);
        }
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }
}
