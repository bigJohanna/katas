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
        return findMaxSumByFrequency(diceHand, 2);

    }

    public static int twoPair(DiceHand diceHand) {
        int fourOfAKindAsTwoPairs = fourOfAKind(diceHand);

        if (fourOfAKindAsTwoPairs != 0)
            return fourOfAKindAsTwoPairs;

        else {
            int pair1 = findMaxSumByFrequency(diceHand, 2);

            int pair2 = 2 * diceHand.intStream()
                    .filter(i -> i != pair1/2 && //get any that is not equal to value of pair1
                            Collections.frequency(diceHand.listOfInteger(), i) >= 2)
                    .findFirst()
                    .orElse(0);

            return pair1 != 0 && pair2 != 0 ? pair1 + pair2 : 0;
        }
    }

    public static int fourOfAKind(DiceHand diceHand) {
        return findMaxSumByFrequency(diceHand, 4);
    }

    private static int sumByValue(DiceHand diceHand, int value) {
        return diceHand.intStream().filter(d -> d == value).sum();
    }

    private static int findMaxSumByFrequency(DiceHand diceHand, int freq) {
        return freq * diceHand.intStream()
                .filter(i -> Collections.frequency(diceHand.listOfInteger(), i) >= freq)
                .max()
                .orElse(0);
    }

    public static int threeOfAKind(DiceHand diceHand) {
        return findMaxSumByFrequency(diceHand, 3);
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

        int threeOfAKind = 3 * diceHand.intStream()
                .filter(i -> Collections.frequency(diceHand.listOfInteger(), i) == 3)
                .findFirst()
                .orElse(0);

        int pair = 2 * diceHand.intStream()
                .filter(i -> Collections.frequency(diceHand.listOfInteger(), i) == 2)
                .findFirst()
                .orElse(0);

        return threeOfAKind != 0 && pair != 0 ? threeOfAKind + pair : 0;
    }
}