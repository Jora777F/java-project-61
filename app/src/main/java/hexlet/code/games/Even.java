package hexlet.code.games;

import hexlet.code.engine.Engine;

import java.util.Scanner;

public class Even {

    public static void checkEven(int iterations, Scanner scanner, String userName) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int min = 1;
        int max = 100;

        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];

        for (int i = 0; i < iterations; i++) {
            int randomNumber = min + (int)(Math.random() * ((max - min) + 1));
            questions[i] = String.valueOf(randomNumber);
            correctAnswers[i] = isEvenNumber(randomNumber) ? "yes" : "no";
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
