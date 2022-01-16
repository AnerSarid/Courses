public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            // if (a[i] * alpha > 1)
            // b[i] = 1;
            // else
            // if (a[i] * alpha < -1) {
            // b[i] = -1;
            // } else
            b[i] = a[i] * alpha;
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - 1 - i];
            b[a.length - 1 - i] = a[i];
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < (a.length + b.length); i++) {
            if (i < a.length)
                c[i] = a[i];
            else
                c[i] = b[i - a.length];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        if (a.length > b.length) {
            double[] c = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                if (i < b.length) {
                    // if (a[i] + b[i] > 1) {
                    // c[i] = 1;
                    // } else if (a[i] + b[i] < -1)
                    // c[i] = -1;
                    // else
                    c[i] = a[i] + b[i];
                } else
                    c[i] = a[i];
            }
            return c;
        } else {
            double[] c = new double[b.length];
            for (int i = 0; i < b.length; i++) {
                if (i < a.length) {
                    // if (a[i] + b[i] > 1) {
                    // c[i] = 1;
                    // } else if (a[i] + b[i] < -1)
                    // c[i] = -1;
                    // else
                    c[i] = b[i] + a[i];
                } else
                    c[i] = b[i];
            }
            return c;
        }

    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] b = new double[(int) (a.length / alpha)];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[(int) (i * alpha)];
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    private static double[] clamp(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            if (b[i] > 1)
                b[i] = 1;
            if (b[i] < -1)
                b[i] = -1;
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] cowSamp = StdAudio.read("cow.wav");
        double[] chimesSamp = StdAudio.read("chimes.wav");
        double[] harpSamp = StdAudio.read("harp.wav");
        double[] exposureSamp = StdAudio.read("exposure.wav");
        double[] pianoSamp = StdAudio.read("piano.wav");

        // StdAudio.play(clamp(amplify(changeSpeed(exposureSamp, 1.5), 1.2)));
        StdAudio.play(amplify(changeSpeed(exposureSamp, 1.5), 1.2));
        StdAudio.play(changeSpeed(merge(harpSamp, pianoSamp), 3));
        // StdAudio.play(clamp(amplify(mix(harpSamp, pianoSamp), 1.2)));
        StdAudio.play(amplify(mix(harpSamp, pianoSamp), 1.2));
        StdAudio.play(changeSpeed(clamp(amplify(mix(chimesSamp, mix(harpSamp, pianoSamp)), 1.2)), 2));
        StdAudio.play(changeSpeed(merge(cowSamp, reverse(cowSamp)), 1.5));

    }
}