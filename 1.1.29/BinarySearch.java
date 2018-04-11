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

    private static int rank(int key, int[] array)
    {
        return rank(key, array, 0, array.length);
    }
    
    private static int count(int key, int[] array)
    {
        int position = rank(key, array);
        if (position < 0) 
            return -1;
        
        int counter = 1;
        int spread = 1;
        
        // search left
        while (position-spread > 0 && array[position-spread] == key)
        {
            counter++;
            spread++;
        }
        
        spread = 1;
        
        // search right
        while (position+spread < array.length && array[position+spread] == key)
        {
            counter++;
            spread++;
        }
        return counter;
    }
    private static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            StdOut.println(array[i]);
        }
    }
    
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        int i = rank(77, whitelist);
        int j = count(77, whitelist);
        StdOut.printf("i = %d, j = %d\n\n", i, j);
        for (int x = i; x < i + j - 1; x++)
        {
            assert whitelist[x] == whitelist[i];
        }
        printArray(whitelist);
    }
}
