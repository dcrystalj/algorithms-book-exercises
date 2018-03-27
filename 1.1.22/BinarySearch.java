public class BinarySearch
{
    private static void printDepth(int n) 
    {
        for (int i = 0; i < n; ++i) 
        {
            System.out.print(' ');
        }
    }
    private static void rank(int key, int[] array, int low, int high, int depth)
    {
        if (low > high) {
            System.out.println("-1");
            return;
        }
        printDepth(depth);
        System.out.printf("%d %d \n", low, high);
        
        int middle = low + (high - low) / 2;

        if (array[middle] == key) return;
        if (key < array[middle]) rank(key, array, low, middle - 1, depth + 1);
        else rank(key, array, middle + 1, high, depth + 1);
    }
    
    public static void main(String[] args)
    {
        int[] array = {1, 3, 4, 5, 7, 8};
        rank(3, array, 0, array.length-1, 0);
    }
}
