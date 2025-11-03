package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

import java.util.Scanner;

public class Prime {

    public static void checkPrime(int iterations, Scanner scanner, String userName) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];

        for (int i = 0; i < iterations; i++) {
            int number = RandomGenerator.generateNumber(2, 100);
            questions[i] = String.valueOf(number);
            correctAnswers[i] = isPrimeNumber(number) ? "yes" : "no";
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);

    }

    /**
     * Алгоритм перебора делителей
     * @param number число
     * @return true - если число простое
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
