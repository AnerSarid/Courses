public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double hNum = 0;

        for (int i = 1; i <= n; i++) {
            hNum += (1 / (Math.pow(i, r)));
        }
        System.out.println(hNum);
    }
}
