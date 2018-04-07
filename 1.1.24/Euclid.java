import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Euclid
{
    private static int sequence(int p, int q) 
    {
        StdOut.printf("%d %d\n", p, q);
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return sequence(q, r);
        
    }
    
    public static void main(String[] args)
    {
//        int p = 105;
//        int q = 24;
        int p = StdIn.readInt();
        int q = StdIn.readInt();
        int result = sequence(p, q);
        StdOut.printf("result: %d", result);
    }
}
