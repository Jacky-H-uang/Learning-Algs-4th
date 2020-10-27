package C1_Basic.StackTest1;

import edu.princeton.cs.algs4.*;

public class Reverse {
    public static void main(String[] args)
    {
        Stack<Integer> stack;
        stack = new Stack<>();
        while (!StdIn.isEmpty())
        {
            stack.push(StdIn.readInt());
        }
        for(int i:stack)
        {
            StdOut.println(i);
        }
    }
}
