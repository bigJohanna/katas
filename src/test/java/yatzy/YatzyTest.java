package yatzy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class YatzyTest {

    @Test
    public void chanceScoresSumOfAllDice() {
        int expected = 15;
        int actual = Yatzy.chance(new Yatzy.DiceHand(2, 3, 4, 5, 1));
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.chance(new Yatzy.DiceHand(3, 3, 4, 5, 1)));
    }

    @Test
    public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy.yatzy(new Yatzy.DiceHand(4, 4, 4, 4, 4));
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy(new Yatzy.DiceHand(6, 6, 6, 6, 6)));
        assertEquals(0, Yatzy.yatzy(new Yatzy.DiceHand(6, 6, 6, 6, 3)));
    }

    @Test
    public void sumOfOnes_test() {
        assertEquals(1, Yatzy.ones(new Yatzy.DiceHand(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(new Yatzy.DiceHand(1, 2, 1, 4, 5)));
        assertEquals(0, Yatzy.ones(new Yatzy.DiceHand(6, 2, 2, 4, 5)));
        assertEquals(4, Yatzy.ones(new Yatzy.DiceHand(1, 2, 1, 1, 1)));
    }

    @Test
    public void sumOfTwos_test() {
        assertEquals(4, Yatzy.twos(new Yatzy.DiceHand(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy.twos(new Yatzy.DiceHand(2, 2, 2, 2, 2)));
    }

    @Test
    public void sumOfThrees_test() {
        assertEquals(6, Yatzy.threes(new Yatzy.DiceHand(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy.threes(new Yatzy.DiceHand(2, 3, 3, 3, 3)));
    }

    @Test
    public void sumOfFours_test() {
        assertEquals(12, Yatzy.fours(new Yatzy.DiceHand(4, 4, 4, 5, 5)));
        assertEquals(8, Yatzy.fours(new Yatzy.DiceHand(4, 4, 5, 5, 5)));
        assertEquals(4, Yatzy.fours(new Yatzy.DiceHand(4, 5, 5, 5, 5)));
    }

    @Test
    public void sumOfFives_test() {
        assertEquals(10, Yatzy.fives(new Yatzy.DiceHand(4, 4, 4, 5, 5)));
        assertEquals(15, Yatzy.fives(new Yatzy.DiceHand(4, 4, 5, 5, 5)));
        assertEquals(20, Yatzy.fives(new Yatzy.DiceHand(4, 5, 5, 5, 5)));
    }

    @Test
    public void sumOfSixes_test() {
        assertEquals(0, Yatzy.sixes(new Yatzy.DiceHand(4, 4, 4, 5, 5)));
        assertEquals(6, Yatzy.sixes(new Yatzy.DiceHand(4, 4, 5, 5, 6)));
        assertEquals(18, Yatzy.sixes(new Yatzy.DiceHand(4, 5, 6, 6, 6)));
    }

    @Test
    public void sumOfHighestPair_test() {
        assertEquals(6, Yatzy.onePair(new Yatzy.DiceHand(3, 4, 3, 5, 6)));
        assertEquals(10, Yatzy.onePair(new Yatzy.DiceHand(5, 3, 3, 3, 5)));
        assertEquals(12, Yatzy.onePair(new Yatzy.DiceHand(5, 3, 6, 6, 5)));
    }

    @Test
    public void sumOfHighestTwoPairs_test() {
        assertEquals(16, Yatzy.twoPair(new Yatzy.DiceHand(3, 3, 5, 4, 5)));
        assertEquals(16, Yatzy.twoPair(new Yatzy.DiceHand(3, 3, 5, 5, 5)));
        assertEquals(20, Yatzy.twoPair(new Yatzy.DiceHand(3, 5, 5, 5, 5)));
    }

    @Test
    public void sumOfThreeOfAKind_test() {
        assertEquals(9, Yatzy.threeOfAKind(new Yatzy.DiceHand(3, 3, 3, 4, 5)));
        assertEquals(15, Yatzy.threeOfAKind(new Yatzy.DiceHand(5, 3, 5, 4, 5)));
        assertEquals(9, Yatzy.threeOfAKind(new Yatzy.DiceHand(3, 3, 3, 3, 5)));
    }

    @Test
    public void sumOfFourOfAKind_test() {
        assertEquals(12, Yatzy.fourOfAKind(new Yatzy.DiceHand(3, 3, 3, 3, 5)));
        assertEquals(20, Yatzy.fourOfAKind(new Yatzy.DiceHand(5, 5, 5, 4, 5)));
        assertEquals(9, Yatzy.threeOfAKind(new Yatzy.DiceHand(3, 3, 3, 3, 3)));
    }

    @Test
    public void givenDicehandOneToFiveReturn15() {
        assertEquals(15, Yatzy.smallStraight(new Yatzy.DiceHand(1, 2, 3, 4, 5)));
        assertEquals(15, Yatzy.smallStraight(new Yatzy.DiceHand(2, 3, 4, 5, 1)));
        assertEquals(0, Yatzy.smallStraight(new Yatzy.DiceHand(1, 2, 2, 4, 5)));
    }

    @Test
    public void givenDiceHandTwoToSixReturn20() {
        assertEquals(20, Yatzy.largeStraight(new Yatzy.DiceHand(6, 2, 3, 4, 5)));
        assertEquals(20, Yatzy.largeStraight(new Yatzy.DiceHand(2, 3, 4, 5, 6)));
        assertEquals(0, Yatzy.largeStraight(new Yatzy.DiceHand(1, 2, 2, 4, 5)));
    }

    @ParameterizedTest
    @CsvSource({
            "0,2, 3, 4, 5, 6",
            "18,6, 2, 2, 2, 6",
            "0, 2,2,3,3,4",
            "0,2,2,2,2,2"}) //Assuming 5 of a kind cannot count as full house
    public void sumOfPairAndThreeOfAKind(int expected, int input1, int input2, int input3, int input4, int input5) {
        assertEquals(expected, Yatzy.fullHouse(new Yatzy.DiceHand(input1, input2, input3, input4, input5)));

    }
}