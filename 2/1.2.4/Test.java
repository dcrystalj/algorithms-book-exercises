
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.*;

public class Test {

    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];
        boolean isCircular = false;
        for (int i = 0; i < s1.length; i++) {
            if (s2.equals(s1.substring(i, s1.length) + s1.substring(0, i))) {
                isCircular = true;
                break;
            }
        }
        StdOut("%b", isCircular);
    }
}
