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
    
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        char sign = args[1].charAt(0);
        Arrays.sort(whitelist);
        
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            int found = rank(key, whitelist, 0, whitelist.length - 1);
            
            if (sign == '+' && found < 0 || sign == '-' && found > 0) 
                StdOut.println(key);
        }
    }
}
