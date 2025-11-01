package hexlet.code.games;

import hexlet.code.engine.Engine;

import java.util.Scanner;
import java.util.Random;

public class Even {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;
    private static final Random RANDOM = new Random();

    public static void checkEven(int iterations, Scanner scanner, String userName) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];

        for (int i = 0; i < iterations; i++) {
            int randomNumber = RANDOM.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            questions[i] = String.valueOf(randomNumber);
            correctAnswers[i] = isEvenNumber(randomNumber) ? "yes" : "no";
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
