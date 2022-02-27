public class Bar implements Comparable<Bar> {

    private final int value;
    private final String name;
    private final String category;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null || category == null || value < 0)
            throw new IllegalArgumentException("Illegal values");


        this.name = name;
        this.value = value;
        this.category = category;

    }

    // Returns the name of this bar.
    public String getName() {
        return this.name;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.value;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.category;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null)
            throw new NullPointerException("Can't compare");

        if (this.value < that.value)
            return -1;
        if (this.value == that.value)
            return 0;
        else
            return 1;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        Bar bar1 = new Bar("Beijing", 22674, "East Asia");
        Bar bar2 = new Bar("Cairo", 19850, "Middle East");
        StdOut.println(bar1.getValue());
        StdOut.println(bar1.getCategory());
        StdOut.println(bar1.getName());
        StdOut.println(bar1.compareTo(bar2));
    }

}
