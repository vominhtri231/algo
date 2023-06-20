package tri.algo.types.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        return new WordSearcher(board, word.toCharArray()).hasWord();
    }

    static class WordSearcher {
        private final char[][] board;
        private final char[] word;

        WordSearcher(char[][] board, char[] word) {
            this.board = board;
            this.word = word;
        }

        boolean hasWord() {
            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[0].length; j++) {
                    if (hasWord(new HashSet<>(), new Point(i, j), 0)) {
                        return true;
                    }
                }

            return false;
        }

        private boolean hasWord(Set<Point> over, Point point, int position) {
            if (!isValid(point, word[position])) {
                return false;
            }

            if (position == word.length - 1) {
                return true;
            }

            over.add(point);

            for (Point next : point.allMoves()) {
                if (over.contains(next)) {
                    continue;
                }

                if (hasWord(over, next, position + 1)) {
                    return true;
                }
            }

            over.remove(point);
            return false;
        }

        private boolean isValid(Point point, char expected) {
            return point.valid(board.length, board[0].length)
                    && board[point.x][point.y] == expected;
        }
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        List<Point> allMoves() {
            return Arrays.asList(up(), down(), right(), left());
        }

        Point up() {
            return new Point(x + 1, y);
        }

        Point down() {
            return new Point(x - 1, y);
        }

        Point right() {
            return new Point(x, y + 1);
        }

        Point left() {
            return new Point(x, y - 1);
        }

        boolean valid(int xMax, int yMax) {
            return x >= 0 && x < xMax && y >= 0 && y < yMax;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
