public class Huntingtons {

    public static int maxRepeats(String dna) {
        int maxRep = 0;

        String hunting = "CAG";
        while (dna.contains(hunting)) {
            maxRep++;
            hunting = hunting.concat("CAG");
        }

        return maxRep;
    }

    public static String removeWhitespace(String s) {
        String temp1 = s.replace("\n", "");
        String temp2 = temp1.replace("\t", "");
        String temp3 = temp2.replace(" ", "");
        return temp3;
    }

    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10 || maxRepeats > 181)
            return "not human";
        else if (maxRepeats < 36)
            return "normal";
        else if (maxRepeats < 40)
            return "high risk";
        else if (maxRepeats <= 180)
            return "Huntington's";
        return "not human";
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String genSeq = in.readAll();
        genSeq = removeWhitespace(genSeq);

        StdOut.println("max repeats = " + maxRepeats(genSeq));
        StdOut.println(diagnose(maxRepeats(genSeq)));
        in.close();
    }
}
