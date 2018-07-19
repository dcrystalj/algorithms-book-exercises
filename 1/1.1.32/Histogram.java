import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Histogram
{  
    private static double maxValue(int[] array)
    {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < array.length; i++)
        {
            max = Math.max(array[i], max);
        }
        return max;
    }
    
    private static void drawHistogram(int[] histogram)
    {
        int n = histogram.length;
        double width = 0.9 / n;
        double max = maxValue(histogram);
        for (int i = 0; i < n; i++)
        {
            double x = 0.05 + width * i;
            double y = histogram[i] * 0.45 / max + 0.05;
            double rw = width / 2 - 0.01;
            double rh = histogram[i] * 0.45 / max;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
    
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        double left = Double.parseDouble(args[1]);
        double right = Double.parseDouble(args[2]);
        
        int[] histogram = new int[n+1];
        double intervalLength = (right - left) / n;
        while (!StdIn.isEmpty()) 
        {
            double value = StdIn.readDouble();
            int intervalIndex = (int) ((value - left) / intervalLength);
            histogram[intervalIndex]++;
        }
        drawHistogram(histogram);
    }
}
