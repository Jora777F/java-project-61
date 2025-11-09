package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

public class Prime {

    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void run() {
        String gameDescription = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        String[][] questionAndAnswers = new String[Engine.ROUNDS][2];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int number = RandomGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER);
            questionAndAnswers[i][0] = String.valueOf(number);
            questionAndAnswers[i][1] = isPrimeNumber(number) ? "yes" : "no";
        }

        Engine.runGame(gameDescription, questionAndAnswers);
    }

    /**
     * Перебор делителей (trial division).
     *
     * @param number число, которое необходимо проверить
     * @return true - если число является простым, в противном случае - false
     */
    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        int lastFactor = ((int) Math.sqrt(number));

        for (int i = 2; i <= lastFactor; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
