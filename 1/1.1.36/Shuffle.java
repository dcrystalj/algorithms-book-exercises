import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class Shuffle
{  
    public static void shuffle(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++)
        { // Exchange a[i] with random element in a[i..N-1
            int r = i + StdRandom.uniform(n-i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    
    private static void countStats(int[][] counter, int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            counter[i][array[i]]++;
        }
    }
        
    private static void print2dArray(int[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                StdOut.printf("%d ", array[i][j]);
            }
            StdOut.println();
        }
    }
    
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[][] counter = new int[m][m];
        int[] array = new int[m];
        for (int j = 0; j < n; j++) 
        {
            // initialize
            for (int i = 0; i < m; i++) 
            {
                array[i] = i;    
            }
            shuffle(array);
            countStats(counter, array);
        }
        print2dArray(counter);

        /* 
        * try to run:
        * java Shuffle 3 1000000
        * all values should be 33xxx which is close to n/m
        */
    }
}
