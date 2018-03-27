import edu.princeton.cs.algs4.StdOut;

public class Logarithm
{
    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
    public static double lg(int n)
    {
        return Math.log(factorial(n));
    }
    public static void main(String[] args)
    {
        StdOut.println(lg(10));
    }
}
