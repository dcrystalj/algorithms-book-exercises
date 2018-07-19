public class Fragment {
    
    private static final int N = 4;
    private static final int M = 3;

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}};

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }
}
