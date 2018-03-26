public class Fragment {
    public static void main(String[] args) {
        int n = 10;
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.append(n % 2);
            n /= 2;
        }
        System.out.println(result.reverse());
    }
}
