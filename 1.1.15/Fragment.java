public class Fragment {
    private static int[] histogram(int[] a, int m) {
        int[] arr = new int[m];
        for (int i = 0; i < m; ++i) {
            arr[a[i]]++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] arr = new int[] {1, 3, 2, 3, 1, 1, 2};
        int[] expected = new int[] {0, 3, 2, 2, 0, 0, 0, 0};
        int[] result = histogram(arr, n);
        for (int i = 0; i < n; i++) {
            if (expected[i] != result[i]) {
                System.out.println("expected " + expected[i]  + " != " + result[i]);
                return;
            }
        }
        System.out.println("All is ok");
    }
}
