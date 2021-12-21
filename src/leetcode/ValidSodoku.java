package leetcode;

public class ValidSodoku {

    public boolean isValidSudoku(char[][] board) {
        return isValidRows(board) && isValidCols(board) && isValidBoxes(board);
    }

    private boolean isValidRows(char[][] board) {
        for (char[] row : board) {
            if (!isValid(row)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidCols(char[][] board) {
        for (int i = 0; i < 9; i++) {
            char[] col = new char[9];

            for (int j = 0; j < 9; j++) {
                col[j] = board[j][i];
            }

            if (!isValid(col)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidBoxes(char[][] board) {
        for (int box = 0; box < 9; box++) {
            int bigRow = box / 3;
            int bigCol = box % 3;

            char[] boxValues = new char[9];

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    boxValues[i * 3 + j] = board[bigRow * 3 + i][bigCol * 3 + j];
                }

            if (!isValid(boxValues)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[] group) {
        boolean[] visited = new boolean[9];
        for (char v : group) {
            if (v == '.') {
                continue;
            }
            int nValue = v - '1';
            if (visited[nValue]) {
                return false;
            }

            visited[nValue] = true;
        }

        return true;
    }
}
