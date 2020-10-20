package yatzy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yatzy {

    public Yatzy() {
    }

    static class DiceHand {
        private final int[] dice;

        DiceHand(int d1, int d2, int d3, int d4, int d5) {
            this.dice = new int[]{d1, d2, d3, d4, d5};
        }

        public IntStream intStream() {
            return IntStream.of(dice);
        }
<<<<<<< HEAD

        public List<Integer> listOfInteger() {
            return Arrays.stream(dice)
                    .boxed()
                    .collect(Collectors.toList());
        }
    }

    public static int chance(DiceHand diceHand) {
        return diceHand.intStream().sum();
    }

    public static int yatzy(DiceHand diceHand) {
        return diceHand.intStream().distinct().count() == 1 ? 50 : 0;
    }

    public static int ones(DiceHand diceHand) {
        return sumByValue(diceHand, 1);
    }

    public static int twos(DiceHand diceHand) {
        return sumByValue(diceHand, 2);
    }

    public static int threes(DiceHand diceHand) {
        return sumByValue(diceHand, 3);
    }


    public static int fours(DiceHand diceHand) {
        return sumByValue(diceHand, 4);
    }

    public static int fives(DiceHand diceHand) {
        return sumByValue(diceHand, 5);
    }

    public static int sixes(DiceHand diceHand) {
        return sumByValue(diceHand, 6);
    }

    public static int onePair(DiceHand diceHand) {
        return findMaxSumByLargerThanEqualsFrequency(diceHand, 2);

    }

    public static int twoPair(DiceHand diceHand) {
        int fourOfAKindAsTwoPairs = fourOfAKind(diceHand);

        if (fourOfAKindAsTwoPairs != 0)
            return fourOfAKindAsTwoPairs;

        else {
            int pair1 = findMaxSumByLargerThanEqualsFrequency(diceHand, 2);

            int pair2 = 2 * diceHand.intStream()
                    .filter(i -> i != pair1/2 && //get any that is not equal to value of pair1
                            Collections.frequency(diceHand.listOfInteger(), i) >= 2)
                    .findFirst()
                    .orElse(0);

            return pair1 != 0 && pair2 != 0 ? pair1 + pair2 : 0;
        }
    }

    public static int fourOfAKind(DiceHand diceHand) {
        return findMaxSumByLargerThanEqualsFrequency(diceHand, 4);
    }

    private static int sumByValue(DiceHand diceHand, int value) {
        return diceHand.intStream().filter(d -> d == value).sum();
    }

    private static int findMaxSumByLargerThanEqualsFrequency(DiceHand diceHand, int freq) {
        return freq * diceHand.intStream()
                .filter(i -> Collections.frequency(diceHand.listOfInteger(), i) >= freq)
                .max()
                .orElse(0);
    }

    private static int findMaxSumByFrequency(DiceHand diceHand, int freq){
        return diceHand.intStream()
                .filter(i -> Collections.frequency(diceHand.listOfInteger(), i) == freq)
                .findFirst()
                .orElse(0);
    }

    public static int threeOfAKind(DiceHand diceHand) {
        return findMaxSumByLargerThanEqualsFrequency(diceHand, 3);
    }

    public static int smallStraight(DiceHand diceHand) {
        Arrays.sort(diceHand.dice);
        return Arrays.equals(diceHand.dice, new int[]{1, 2, 3, 4, 5}) ? 15 : 0;
    }

    public static int largeStraight(DiceHand diceHand) {
        Arrays.sort(diceHand.dice);
        return Arrays.equals(diceHand.dice, new int[]{2, 3, 4, 5, 6}) ? 20 : 0;
    }

    public static int fullHouse(DiceHand diceHand) {

        int threeOfAKind = 3 * findMaxSumByFrequency(diceHand,3);

        int pair = 2 * findMaxSumByFrequency(diceHand,2);

        return threeOfAKind != 0 && pair != 0 ? threeOfAKind + pair : 0;
=======
        return sum;
    }

    public int fives()
    {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++)
            if (dice[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes()
    {
        int sum = 0;
        for (int at = 0; at < dice.length; at++)
            if (dice[at] == 6)
                sum = sum + 6;
        return sum;
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}