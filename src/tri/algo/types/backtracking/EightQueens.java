package tri.algo.types.backtracking;

import java.util.Arrays;

public class EightQueens {

    void putQueen(int[] queens, int row) {
        if (row == queens.length) {
            printResult(queens);
            return;
        }

        for (int col = 0; col < queens.length; col++) {
            queens[row] = col;

            if (isValid(queens, row, col)) {
                putQueen(queens, row + 1);
            }
        }
    }

    boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] + i == row + col || i - queens[i] == row - col) {
                return false;
            }
        }

        return true;
    }

    void printResult(int[] queens) {
        System.out.println(Arrays.toString(queens));
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.putQueen(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0);
    }
}
