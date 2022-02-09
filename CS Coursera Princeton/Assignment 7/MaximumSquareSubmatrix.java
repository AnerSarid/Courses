public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int largest = 0, templargest = 0, length = a.length;
        int[][] dynmax = new int[length][length];

        for (int i = length - 1; i >= 0; i--) {
            for (int j = length - 1; j >= 0; j--) {
                if (i == length - 1 || j == length - 1)
                    dynmax[i][j] = a[i][j];
                else if (a[i][j] == 1) {
                    templargest = dynmax[i + 1][j];
                    if (dynmax[i + 1][j + 1] < templargest)
                        templargest = dynmax[i + 1][j + 1];
                    if (dynmax[i][j + 1] < templargest)
                        templargest = dynmax[i][j + 1];
                    dynmax[i][j] = templargest + 1;
                } else {
                    dynmax[i][j] = 0;
                }

                if (dynmax[i][j] > largest)
                    largest = dynmax[i][j];
            }
        }
        return largest;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];

        int i = 0, j = 0;
        while (!StdIn.isEmpty()) {
            a[i][j] = StdIn.readInt();
            j++;
            if (j == n) {
                i++;
                j = 0;
            }
        }

        StdOut.print(size(a));

    }
}