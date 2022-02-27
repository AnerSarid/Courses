public class RevesPuzzle {

    private static void rec4Pole(int n, String from, String temp1, String temp2, String to) {
        int k = (int) Math.round(n + 1 - Math.sqrt((2 * n + 1)));

        if (k == 0) {
            System.out.println("Move disc " + n + " from " + from + " to " + to);
            return;
        }

        rec4Pole(k, from, to, temp2, temp1);
        rec3Pole(n - k, k, from, temp2, to);
        rec4Pole(k, temp1, from, temp2, to);

    }

    private static void rec3Pole(int n, int k, String from, String temp, String to) {
        if (n == 0)
            return;
        rec3Pole(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        rec3Pole(n - 1, k, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        rec4Pole(n, "A", "B", "C", "D");
    }

}
