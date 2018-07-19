public class Fragment {
    
    private static final int N = 99;
    
    private static int lg(int n) {
        int cnt = 0;
        while (n >= 2) {
            n /= 2;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(lg(N));
    }
}
