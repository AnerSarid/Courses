public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length - 1];
        int[] s = new int[a.length + 1];

        for (int i = 1; i < args.length; i++) {
            a[i - 1] = Integer.parseInt(args[i]);
            s[i] = a[i - 1] + s[i - 1];
        }

        for (int j = 0; j < m; j++) {
            int r = (int) (Math.random() * (s[s.length - 1]));
            for (int i = 1; i <= s.length; i++) {
                if (s[i - 1] <= r && r < s[i])
                    System.out.print(i + " ");
            }
        }
    }
}
