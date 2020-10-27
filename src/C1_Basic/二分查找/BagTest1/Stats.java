package C1_Basic.二分查找.BagTest1;

import edu.princeton.cs.algs4.*;

/**
 * This Pragram Using The Als 4edtion's Bag
 * @version JDK-14
 * @author Jacky
 */

public class Stats {
    public static void main(String[] args)
    {
        Bag<Double> numbers = new Bag<Double>();
        int count = 0;
        while (!StdIn.isEmpty())                    //放10进入Bag
        {
            count++;
            numbers.add(StdIn.readDouble());
            if(count >=10)
            {
                break;
            }
        }
        int N = numbers.size();
        double sum = 0.0;
        for(double x:numbers)
        {
            sum += x;
        }
        double mean = sum/N;
        sum = 0.0;
        for(double x:numbers)
        {
            sum += (x-mean)*(x-mean);
        }
        double std = Math.sqrt(sum/(N-1));
        StdOut.printf("Mean: %.2f\n",mean);
        StdOut.printf("Std dev: %.2f\n",std);
    }
}
