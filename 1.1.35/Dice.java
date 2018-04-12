import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class Dice
{  
    
    private static boolean compareVectors(double[] a, double[] b)
    {
        for (int i = 2; i < a.length; i++) {
            if (Math.round(a[i] * 1000) != Math.round(b[i] * 1000)) return false;
        }
        return true;
    }
    
    private static double[] exactProbabilityDistribution()
    {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;
        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }

    private static double[] empiricalProbabilityDistribution(int n)
    {
        double[] distribution = new double[13];
        for (int i = 0; i < n; i++) {
            int diceSum = StdRandom.uniform(1, 7) + StdRandom.uniform(1, 7);
            distribution[diceSum] += 1.0;
        }
        for (int k = 2; k <= 12; k++)
            distribution[k] /= n;
        return distribution;
    }
    
    public static void main(String[] args)
    {
        double[] exact = exactProbabilityDistribution();
        for (int n = 100000; n < 1000000; n += 100) {
            double[] approx = empiricalProbabilityDistribution(n);
            if (compareVectors(exact, approx))
            {
                StdOut.printf("N has to be %d to match exact results to 3 decimals", n);
                break;
            }
            /*
                uncomment this to debug
                for (int i = 0; i < 13; i++) {
                    StdOut.printf("%.3f ", exact[i]);
                }
                StdOut.println();
                for (int i = 0; i < 13; i++) {
                    StdOut.printf("%.3f ", approx[i]);
                }
                StdOut.println();
                StdOut.println();
            */
        }
    }
}