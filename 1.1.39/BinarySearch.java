import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class BinarySearch
{
    private static int rank(int key, int[] array, int low, int high)
    {
        if (low > high) return -1;        
        int middle = low + (high - low) / 2;
        if (array[middle] == key) return middle;
        if (key < array[middle]) return rank(key, array, low, middle - 1);
        else return rank(key, array, middle + 1, high);
        
    }

    private static int[] makeRandomArray(int n)
    {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = StdRandom.uniform(100000, 1000000);
        }
        return array;
    }
    
    public static void main(String[] args)
    {
        int trials = Integer.parseInt(args[0]);
        int[] trial = new int[4];
        
        for (int i = 3; i < 7; i++) 
        {
            int n = (int) Math.pow(10, i);
            int counter = 0;
            for (int j = 0; j < trials; j++) {
                
                int[] a = makeRandomArray(n);
                int[] b = makeRandomArray(n);
                Arrays.sort(a);
                for (int k = 0; k < n; k++) {                    
                    if (rank(b[k], a, 0, n - 1) >= 0) {
                        counter++;
                    }
                }
            }
            trial[i-3] = counter / trials;
        }
        StdOut.printf("N  10^3    10^4    10^5    10^6   \n");
        StdOut.printf("%7d %7d %7d %7d\n", trial[0], trial[1], trial[2], trial[3]);
    }
}
