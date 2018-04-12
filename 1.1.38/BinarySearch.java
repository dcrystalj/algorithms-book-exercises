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

    private static int bruteForce(int key, int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) return i;
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            int found = rank(key, whitelist, 0, whitelist.length - 1);
            // int found = bruteForce(key, whitelist);  // uncomment to test this
        }

        // NOTE: to time program use `time java BinarySearch largeW.txt < largeT.txt
    }
}
