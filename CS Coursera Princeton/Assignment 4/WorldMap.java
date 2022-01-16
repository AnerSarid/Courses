public class WorldMap {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();

        int width, height, vertices;
        double[] x, y;
        String name;
        width = StdIn.readInt();
        height = StdIn.readInt();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            name = StdIn.readString();

            vertices = StdIn.readInt();
            x = new double[vertices];
            y = new double[vertices];

            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }

}
