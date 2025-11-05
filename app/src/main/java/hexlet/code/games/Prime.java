package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

public class Prime {

    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void checkPrime() {
        String gameDescription = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        int iterations = Engine.getNumberIterations();

        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];

        for (int i = 0; i < iterations; i++) {
            int number = RandomGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER);
            questions[i] = String.valueOf(number);
            correctAnswers[i] = isPrimeNumber(number) ? "yes" : "no";
        }

        Engine.runGame(gameDescription, questions, correctAnswers);
    }

    /**
     * Перебор делителей (trial division).
     * @param number число, которое необходимо проверить
     * @return true - если число является простым, в противном случае - false
     */
    private static boolean isPrimeNumber(int number)  {
        int firstFactor = 2;
        int lastFactor = ((int) Math.sqrt(number)) + 1;

        for (int i = firstFactor; i <= lastFactor; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
