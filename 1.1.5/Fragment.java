import edu.princeton.cs.algs4.StdRandom;

public class Fragment {
    public static void main(String[] args) {
        double x, y;
        x = StdRandom.random();
        y = StdRandom.random();
        if (x > 0 && y > 0 && x < 1 && y < 1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
