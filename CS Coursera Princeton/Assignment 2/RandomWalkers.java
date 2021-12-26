public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double averageSteps = 0;
        for (int i = 0; i < trials; i++) {
            int steps = 0;
            int x = 0, y = 0;
            while ((Math.abs(x) + Math.abs(y)) < r) {
                double rand = Math.random();
                if (rand < .25) {
                    x++;
                } else if (rand < 0.5) {
                    y++;
                } else if (rand < 0.75) {
                    x--;
                } else {
                    y--;
                }
                steps++;
            }
            averageSteps = (averageSteps + steps);
        }
        averageSteps = (averageSteps / trials);
        System.out.println("average number of steps = " + averageSteps);
    }
}
