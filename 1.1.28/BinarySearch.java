import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class BinarySearch
{
//    private static int rank(int key, int[] array, int low, int high)
//    {
//        if (low > high) return -1;        
//        int middle = low + (high - low) / 2;
//        if (array[middle] == key) return middle;
//        if (key < array[middle]) return rank(key, array, low, middle - 1);
//        else return rank(key, array, middle + 1, high);
//    }
    
    private static int[] shortenArray(int[] originalArray, int length)
    {
        int[] newArray = new int[length];
        for (int i = length-1; i >= 0; i--)
        {
            newArray[i] = originalArray[i];
        }
        return newArray;
    }
    
    private static int[] removeDuplicates(int[] array)
    {
        // array must be sorted
        // Rewrite numbers to array without dulicates and cut trailing numbers.
        int uniqueIndex = 0;
        
        for (int i = 0; i < array.length - 1; ++i)
        {
            if (array[i] != array[i+1])
            {
                array[uniqueIndex++] = array[i];
            }  
        }
        return shortenArray(array, uniqueIndex);
    
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
        printArray(removeDuplicates(whitelist));
    }
}
