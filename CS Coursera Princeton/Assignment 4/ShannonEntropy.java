public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] marr = new int[m + 1];
        int count = 0;
        double entropy = 0.0;

        while (!StdIn.isEmpty()) {
            marr[StdIn.readInt()] += 1;
            count++;
        }

        for (int j = 1; j <= m; j++) {
            if (count != 0) {
                double prop = (double) marr[j] / count;
                if (prop != 0) {
                    entropy += (-1 * (prop * (Math.log(prop) / Math.log(2))));
                }
            }

        }

        StdOut.printf("%.4f\n", entropy);
    }
}
