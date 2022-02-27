import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {

        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        In in = new In(args[0]);
        int k = Integer.parseInt(args[1]);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        BarChart chart = new BarChart(title, xAxis, source);


        while (!in.isEmpty()) {
            in.readLine(); // Skipping the empty line between groups

            String nStr = in.readLine();
            int n = Integer.parseInt(nStr);
            Bar[] bars = new Bar[n];

            for (int i = 0; i < n; i++) {
                String line = in.readLine();

                String[] fields = line.split(",", -1);

                chart.setCaption(fields[0]);

                int value = Integer.parseInt(fields[3]);

                bars[i] = new Bar(fields[1], value, fields[4]);
            }

            Arrays.sort(bars);

            if (k == n)
                for (int i = 0; i < k; i++) 
                    chart.add(bars[n - 1 - i].getName(), bars[n - 1 - i].getValue(), bars[n - 1 - i].getCategory());

            if (k > n)
                for (int i = 0; i < n; i++) 
                    chart.add(bars[n - 1 - i].getName(), bars[n - 1 - i].getValue(), bars[n - 1 - i].getCategory());

            if (k < n)
                for (int i = 0; i < k; i++) 
                    chart.add(bars[n - 1 - i].getName(), bars[n - 1 - i].getValue(), bars[n - 1 - i].getCategory());

                

            chart.draw();
            StdDraw.show();
            StdDraw.pause(20);
            chart.reset();
            StdDraw.clear();
        }
        in.close();
    }
}