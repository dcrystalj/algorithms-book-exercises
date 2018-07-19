
// import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.In;
// import java.util.Arrays;

public class Interval1D {
    private static boolean intersect(double[] a, double[] b) {
        return b[0] <= a[1] && a[0] <= b[1];
    }

    private static void printPairs(double[][] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (intersect(points[i], points[j])) {
                    StdOut.printf("intersect => %d %d \n", i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[][] points = new double[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = StdIn.readDouble();
            points[i][1] = StdIn.readDouble();
        }

        printPairs(points);
    }
}
