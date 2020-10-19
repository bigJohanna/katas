package tictactoechecker;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TicTacToeChecker {

    public int checkGame(int[][] game) {
        if (Arrays.stream(game).flatMapToInt(Arrays::stream).min().getAsInt() == 0) {
            return -1;
        } else {
            return winner(game);
        }
    }

    private int winner(int[][] game) {
        int[][] combinations = getAllLines(game);

        return Arrays.stream(combinations)
                .filter(this::threeIsSame)
                .findFirst()
                .map(this::getValue)
                .orElse(0);
    }

    private int getValue(int[] combination) {
        return IntStream.of(combination).sum() / 3;
    }

    private int[][] getAllLines(int[][] game) {
        int[][] columns = separateColumnValuesFromGame(game);
        int[][] diagonals = separateDiagonalValuesFromGame(game);
        int[][] combinations = append(game, columns);
        combinations = append(combinations, diagonals);

        return combinations;
    }

    public static int[][] append(int[][] a, int[][] b) {
        int[][] result = new int[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    private int[][] separateDiagonalValuesFromGame(int[][] game) {
        return new int[][]{
                {game[0][0], game[1][1], game[2][2]}
                , {game[2][0], game[1][1], game[0][2]}
        };
    }

    private int[][] separateColumnValuesFromGame(int[][] game) {
        int[][] columns = new int[3][3];
        for (int i = 0; i < game[0].length; ++i) {
            for (int j = 0; j < game[0].length; ++j)
                columns[i][j] = game[j][i];
        }
        return columns;

    }

    private boolean threeIsSame(int[] row) {
        return Arrays.stream(row).distinct().count() == 1;
    }
}
