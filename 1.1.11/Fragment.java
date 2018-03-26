public class Fragment {
    public static void main(String[] args) {
        boolean[][] n = new boolean[][]{{true, false, true}, {false, false, false}, {true, true, false}};
        System.out.println(""+ 1 + 2 + "");
        // print header
        System.out.print("  ");
        for (int j = 1; j <= n.length; ++j) {
            // print column number
            System.out.print(j + " ");
        }
        System.out.println();

        // print array
        for (int i = 0; i < n.length; ++i) {
            // print row number
            System.out.print((i+1) + " ");
            for (int j = 0; j < n.length; ++j) {
                // print value
                if (n[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
