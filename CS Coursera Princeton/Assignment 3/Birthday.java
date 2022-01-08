public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] sum = new int[n + 2];
        int i, j, date;
        double fraction = 0;

        for (i = 0; i < trials; i++) {
            boolean[] birthdays = new boolean[n];

            for (j = 1; j < n + 2; j++) {
                date = (int) (Math.random() * n);
                if (birthdays[date]) {
                    break;
                }
                birthdays[date] = true;
            }
            sum[j] += 1;
        }

        int total = 0;

        for (i = 1; i < n + 2; i++) {
            total += sum[i];
            fraction = (double) total / trials;
            System.out.println(i + "\t" + sum[i] + "\t" + fraction);
            if (fraction >= 0.5)
                break;
        }
    }
}
