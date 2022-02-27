public class quizADT {
    public static void main(String[] args) {
        String example = "abcdabcdeabcd";
        String s = example.substring(1, 4);
        String t = example.substring(5, 8);
        StdOut.println(s == t);
        StdOut.println(s.length() == t.length());
        StdOut.println(s.equals(t));
    }
}