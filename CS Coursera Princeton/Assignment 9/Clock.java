public class Clock {

    private static final int HOURS_IN_DAY = 24;
    private static final int MINUTES_IN_HOUR = 60;

    private int hours;
    private int minutes;


    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= HOURS_IN_DAY || m < 0 || m >= MINUTES_IN_HOUR)
            throw new IllegalArgumentException("Hours or minutes out of range");

        this.hours = h;
        this.minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {

        if (s.indexOf(':') != 2 || s.length() != 5)
            throw new IllegalArgumentException("String isn't in the correct format");

        String clock = s.substring(0, 5);

        int h = Integer.parseInt(clock, 0, 2, 10);
        int m = Integer.parseInt(clock, 3, 5, 10);

        if (h < 0 || h >= HOURS_IN_DAY || m < 0 || m >= MINUTES_IN_HOUR)
            throw new IllegalArgumentException("Hours or minutes out of range");


        
        this.hours = h;
        this.minutes = m;        
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        return this.hours < that.hours || this.hours == that.hours && this.minutes < that.minutes;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.minutes++;
        
        if (this.minutes == MINUTES_IN_HOUR) {
            this.minutes = 0;
            this.hours++;
            if (this.hours == HOURS_IN_DAY)
                this.hours = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("Delta must be positive");

        int deltah, deltam;
        deltah = delta / MINUTES_IN_HOUR;
        deltam = delta % MINUTES_IN_HOUR;
        this.hours += deltah;
        this.minutes += deltam;

        if (this.minutes >= MINUTES_IN_HOUR) {
            this.minutes = this.minutes % MINUTES_IN_HOUR;
            this.hours++;
        }
        if (this.hours >= HOURS_IN_DAY)
            this.hours = this.hours % HOURS_IN_DAY;        
    }

    // Test client (see below).
    public static void main(String[] args) {
        int h1 = 16;
        int m1 = 25;
        Clock clock1 = new Clock(h1, m1);
        String h2m2 = "23:59";
        Clock clock2 = new Clock(h2m2);

        StdOut.println(clock1.toString());
        StdOut.println(clock2.toString());
        StdOut.println(clock1.isEarlierThan(clock2));
        clock2.tic();
        StdOut.println(clock2.toString());
        clock1.toc(720);
        StdOut.println(clock1.toString());
    }
}
