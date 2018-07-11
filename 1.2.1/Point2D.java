import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class Point2D
{
    private static double distance(double[] point1, double[] point2) 
    {
        return Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2);
    }

    private static double minDistance(double[][] points)
    {
        double minD = 2;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                minD = Math.min(minD, distance(points[i], points[j]));
            }
        }
        return Math.sqrt(minD);
    }
    
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        double[][] points = new double[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = StdRandom.random();
            points[i][1] = StdRandom.random();
        }
        
        StdOut.printf("%.7f\n", minDistance(points));
    }
}
