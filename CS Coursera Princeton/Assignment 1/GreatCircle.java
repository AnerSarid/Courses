public class GreatCircle {
    public static void main(String args[]) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double firstPart = Math.pow(Math.sin((x2 - x1) / 2), 2);
        double secondPart = Math.cos(x1) * Math.cos(x2);
        double thirdPart = Math.pow(Math.sin((y2 - y1) / 2), 2);
        double arcSinSqr = Math.asin(Math.sqrt(firstPart + (secondPart * thirdPart)));
        double multi = 2 * 6371.0;
        double distance = multi * arcSinSqr;
        System.out.println(distance + " kilometers");
    }
}
