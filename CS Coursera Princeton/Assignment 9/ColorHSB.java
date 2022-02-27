public class ColorHSB {

    private static final int MAX_HUE = 360;

    private final int h, s, b;

    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h >= MAX_HUE)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("the brightness must be between 0 and 100");
        
        this.h = h; 
        this.s = s; 
        this.b = b;
    }

    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    public boolean isGrayscale() {
        return s == 0 || b == 0;
    }

    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException("Please input a valid file");
        int part1a = this.h - that.h;
        int part1b = 360-Math.abs(part1a);
        int part2 = this.s - that.s;
        int part3 = this.b - that.b;
        return Math.min(part1a*part1a, part1b*part1b) + part2*part2 + part3*part3;
    }



    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB inputColor = new ColorHSB(h, s, b);

        int finDistance = Integer.MAX_VALUE;
        ColorHSB finColor = null;
        String finName = null;

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h1 = StdIn.readInt();
            int s1 = StdIn.readInt();
            int b1 = StdIn.readInt();

            ColorHSB currColor = new ColorHSB(h1, s1, b1);

            int distance = inputColor.distanceSquaredTo(currColor);

            if (distance < finDistance) {
                finDistance = distance;
                finName = name;
                finColor = currColor;
            }
        }

        StdOut.println(finName + " " + finColor);

    }

}