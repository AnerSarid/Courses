public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long max = (int) Math.cbrt(n);
        int rama = 0;
        long temp = 0;
        for (long a = 1; a < max && rama < 2; a++) {
            if (a != temp) {
                long b = (long) Math.cbrt(n - a * a * a);
                if (a * a * a + b * b * b == n) {
                    rama++;
                    temp = b;
                }
            }

        }
        if (rama == 2)
            return true;
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}