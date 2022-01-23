public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k == 0 && n == 0)
            return 1;
        else if (k < -n || k > n)
            return 0;
        else {
            k = Math.abs(k);
            long[][] trinom = new long[n + k + 1][n + k + 1];
            trinom[0][0] = 1;

            for (int i = 1; i <= n + k; i++) {
                for (int j = 0; j < n + k; j++) {
                    if (j == 0)
                        trinom[i][j] = 2 * trinom[i - 1][j + 1] + trinom[i - 1][j];
                    else if (j < -n || j > n)
                        trinom[i][j] = 0;
                    else
                        trinom[i][j] = trinom[i - 1][j - 1] + trinom[i - 1][j] + trinom[i - 1][j + 1];
                }
            }
            return trinom[n][k];
        }

    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}