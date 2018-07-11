
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.*;

public class Intervall2D {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        Interval2D[] intervals = new Interval2D[n];
        Point2D[][] points = new Point2D[n][2];

        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform(min, max - 0.001);
            double x1 = StdRandom.uniform(x, max);
            double y = StdRandom.uniform(min, max - 0.001);
            double y1 = StdRandom.uniform(y, max);

            Interval1D interval1 = new Interval1D(x, x1);
            Interval1D interval2 = new Interval1D(y, y1);

            intervals[i] = new Interval2D(interval1, interval2);
            intervals[i].draw();

            points[i] = new Point2D[] { new Point2D(x, y), new Point2D(x1, y1) };
        }

        Counter containedInOneAnother = new Counter("contains");
        Counter intersects = new Counter("intersects");

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intervals[i].intersects(intervals[j]))
                    intersects.increment();
                if (intervals[i].contains(points[j][0]) && intervals[i].contains(points[j][1])
                        || intervals[j].contains(points[i][0]) && intervals[j].contains(points[i][1]))
                    containedInOneAnother.increment();
            }
        }

        StdOut.println(intersects);
        StdOut.println(containedInOneAnother);
    }
}
