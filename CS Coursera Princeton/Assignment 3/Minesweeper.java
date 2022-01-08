public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] mines = new boolean[m + 2][n + 2];
        int[][] board = new int[m + 2][n + 2];
        int i, j;

        for (i = 0; i < k;) {
            int rrow = (int) (Math.random() * m) + 1;
            int rcol = (int) (Math.random() * n) + 1;
            if (!mines[rrow][rcol]) {
                mines[rrow][rcol] = true;
                i++;
            }
        }

        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (mines[i - 1][j - 1])
                    board[i][j] += 1;
                if (mines[i][j - 1])
                    board[i][j] += 1;
                if (mines[i + 1][j - 1])
                    board[i][j] += 1;
                if (mines[i - 1][j])
                    board[i][j] += 1;
                if (mines[i + 1][j])
                    board[i][j] += 1;
                if (mines[i - 1][j + 1])
                    board[i][j] += 1;
                if (mines[i][j + 1])
                    board[i][j] += 1;
                if (mines[i + 1][j + 1])
                    board[i][j] += 1;
            }
        }

        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (mines[i][j])
                    System.out.print("*  ");
                else
                    System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
