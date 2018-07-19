import edu.princeton.cs.algs4.StdIn;

public class Reader
{
    
    public static void main(String[] args)
    {
      
      while (StdIn.hasNextLine()) {
        String name = StdIn.readString();
        int number1 = StdIn.readInt();
        int number2 = StdIn.readInt();
        double res = ((double) number1) / number2;
        System.out.printf("%10s %5d %5d %.3f\n", name, number1, number2, res);
      }
    }
}
