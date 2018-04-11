import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class RandomConnection
{  
    private static void drawPoints(double [][] array)
    {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.05);
        for (int i = 0; i < array.length; i++)
        {
            StdDraw.point(array[i][0], array[i][1]);
        }
    }
    
    private static void drawConnections(double [][] array, double p)
    {
        StdDraw.setPenColor(StdDraw.GRAY);                    
        StdDraw.setPenRadius(0.005);        
        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (StdRandom.random() < p) {
                    StdDraw.line(array[i][0], array[i][1], array[j][0], array[j][1]);
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        double radius = 0.3;        
        double [][] points = new double[n][2];        
        double angle = 2 * Math.PI / n;
        for (int i = 0; i < n; i++)
        {
            points[i][0] = 0.5 + Math.sin(i * angle) * radius;
            points[i][1] = 0.5 + Math.cos(i * angle) * radius;
        }
        drawPoints(points);
        drawConnections(points, p);
    }
}
