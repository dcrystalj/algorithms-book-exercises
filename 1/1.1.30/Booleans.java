import edu.princeton.cs.algs4.StdOut;


public class Booleans
{
    private static boolean[][] createNN(int n)
    {
        boolean[][] array = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                array[i][j] = areRelativelyPrime(i, j);
                array[j][i] = array[i][j];
            }
            
        }
        return array;
    }

    private static boolean areRelativelyPrime(int x, int y)
    {
        if (x <= 1 || y <= 1 || x == y) return false;
        for (int i = 2; i <= Math.max(x, y) / 2; ++i)
        {
            if (x % i == 0 && y % i == 0) 
                return false;
        }
        return true;
    }
    
    private static void print2dArray(boolean[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                StdOut.printf("%b ", array[i][j]);
            }
            StdOut.println();
        }
    }
    
    public static void main(String[] args)
    {
        assert areRelativelyPrime(20, 33);
        assert !areRelativelyPrime(45, 51);
        assert !areRelativelyPrime(2, 4);
        boolean[][] array = createNN(10);
        print2dArray(array);
    }
}
