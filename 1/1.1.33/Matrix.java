import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Matrix
{  
    private static double dot(double[] x, double[] y)
    { // vector dot product
        double result = 0;
        for (int i = 0; i < x.length; i++) {
             result += x[i] * y[i];
        }
        return Math.round(result * 100.0) / 100.0;
    }
    
    private static double[][] mult(double[][] a, double[][] b)
    { // matrix-matrix product
        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            result[i] = mult(a[i], b);
        }
        return result;
    }

    private static double[][] transpose(double[][] a)
    { // transpose
        int columns = a[0].length;
        int rows = a.length;
        double[][] transposed = new double[columns][rows];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                transposed[j][i] = a[i][j];
            }
        }
        return transposed;
    }

    private static double[] mult(double[][] a, double[] x)
    { // matrix-vector product
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = dot(a[i], x);
        }
        return result;
    }

    private static double[] mult(double[] y, double[][] a)
    { // vector-matrix product
        double[] result = new double[a[0].length];
        double[][] transposed = transpose(a);
        for (int i = 0; i < a[0].length; i++) {
            result[i] = dot(transposed[i], y);
        }
        return result;
    }

    private static double[][] readMatrix()
    {
        double[][] a = new double[StdIn.readInt()][StdIn.readInt()];                
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = StdIn.readDouble();
            }
        }
        return a;
    }
    
    private static double[] readVector()
    {
        double[] a = new double[StdIn.readInt()];                
        for (int i = 0; i < a.length; i++) {
            a[i] = StdIn.readDouble();
        }
        return a;
    }

    private static void compareMatrixs(double[][] a, double[][] b)
    {
        for (int i = 0; i < a.length; i++) {
            compareVectors(a[i], b[i]);
        }
    }

    private static void compareVectors(double[] a, double[] b)
    {
        for (int i = 0; i < a.length; i++) {
            assert a[i] == b[i];
        }
    }
    
    public static void main(String[] args)
    {
        while (!StdIn.isEmpty()) 
        {
            String tester = StdIn.readString();
            if (tester.equals("dot")) {
                double[] x = readVector();
                double[] y = readVector();
                double result = dot(x, y);
                assert result == StdIn.readDouble();
            } else if (tester.equals("mult-2-matrix")) {
                double[][] a = readMatrix();
                double[][] b = readMatrix();
                double[][] expected = readMatrix();
                compareMatrixs(mult(a, b), expected);
            } else if (tester.equals("transpose")) {
                double[][] a = readMatrix();
                double[][] expected = readMatrix();
                compareMatrixs(transpose(a), expected);
            } else if (tester.equals("mult-matrix-vector")) {
                double[][] a = readMatrix();
                double[] b = readVector();
                double[] expected = readVector();
                compareVectors(mult(a, b), expected);
            } else if (tester.equals("mult-vector-matrix")) {
                double[] b = readVector();
                double[][] a = readMatrix();
                double[] expected = readVector();
                compareVectors(mult(b, a), expected);
            }
        }
    }
}
