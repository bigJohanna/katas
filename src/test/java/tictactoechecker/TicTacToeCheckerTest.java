package tictactoechecker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class TicTacToeCheckerTest {

    TicTacToeChecker board = new TicTacToeChecker();

    @Test
    void givenBoardOfCatsGameReturn0() {
        int[][] game = {{1,2,1},
                        {2,1,2},
                        {2,1,2}};

        assertThat(board.checkGame(game)).isEqualTo(0);
    }

    @Test
    void givenGameIsNotSolvedYetReturnMinus1() {
        int[][] game = {{0,1,2},
                        {1,2,1},
                        {1,1,2}};

        assertThat(board.checkGame(game)).isEqualTo(-1);
    }


    @Test
    void rowIsThreeEqual() {
        int[][] game1 = {
                {1,1,1},
                {2,1,2},
                {1,1,2}};
    assertThat(board.checkGame(game1)).isEqualTo(1);
        int[][] game2 = {
                {1,2,1},
                {2,2,2},
                {1,1,2}};
        assertThat(board.checkGame(game2)).isEqualTo(2);
    }

    @Test
    void columnIsThreeEqual() {
        int[][] test1 = {
                {1,2,1},
                {1,1,2},
                {1,1,2}};
        int[][] test2 = {
                {1,2,2},
                {2,1,2},
                {1,1,2}};
        assertThat(board.checkGame(test1)).isEqualTo(1);
        assertThat(board.checkGame(test2)).isEqualTo(2);
    }

    @Test
    void diagonalIsThreeEqual() {
        int[][] test1 = {
                {1,2,1},
                {1,1,2},
                {2,2,1}};
        assertThat(board.checkGame(test1)).isEqualTo(1);
        int[][] test2 = {
                {1,2,2},
                {1,2,2},
                {2,2,1}};
        assertThat(board.checkGame(test2)).isEqualTo(2);
    }
}