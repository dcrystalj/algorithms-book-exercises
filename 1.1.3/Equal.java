public class Equal {
    public static void main(String[] args) {
        int[] ints = {Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};
        for (int i = 1; i < 3; i++) {
            if (ints[0] != ints[i]) {
                System.out.println("not equal");
                return;
            }
        }
        System.out.println("equal");
    }
}
