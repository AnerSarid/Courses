public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int n = a.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];

        int firstEl = 0, lastEl = n - 1, temp = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (k >= i) {
                a[firstEl] = i;
                firstEl++;
                k -= i;
            } else if (k < i && k > 0) {
                temp = n - 1 - (int) k;
                a[temp] = i;
                k = 0;
            } else {
                if (lastEl != temp) {
                    a[lastEl] = i;
                    lastEl--;
                } else {
                    a[lastEl - 1] = i;
                    lastEl -= 2;
                }

            }

        }
        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] perm = generate(n, k);
        for (int i = 0; i < n; i++) {
            StdOut.print(perm[i] + " ");
        }
    }
}
