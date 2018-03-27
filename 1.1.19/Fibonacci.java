import edu.princeton.cs.algs4.StdOut;

public class Fibonacci
{
    private static long[] memoization = new long[10000];
    public static long f(int n)
    {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memoization[n] != 0) {
            return memoization[n];
        } 
        memoization[n] = f(n-1) + f(n-2);
        return memoization[n];
    }
    public static void main(String[] args)
    {
        for (int n = 0; n < 100; n++)
        StdOut.println(n + " " + f(n));
    }
}
