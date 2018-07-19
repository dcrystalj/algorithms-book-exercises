import edu.princeton.cs.algs4.StdOut;

public class Binominal
{
    private static int counter;
    private static double[][] memo = new double[101][51];
    public static double binominal(int n, int k, double p)
    {
        counter += 1;
        if ((n == 0) || (k < 0)) return 1.0;
        if (memo[n][k] != 0.0) return memo[n][k];
        memo[n][k] = (1.0 - p) * binominal(n-1, k, p) + p * binominal(n-1, k-1, p);
        return memo[n][k];
    }
    
    
    public static void main(String[] args)
    {
        double result = binominal(100, 50, 0.001);
        StdOut.println(result);
        StdOut.println(counter);
    }
}
