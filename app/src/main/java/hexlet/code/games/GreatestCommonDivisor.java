package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void search(int iterations, Scanner scanner, String userName) {
        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];

        System.out.println("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < iterations; i++) {
            int firstNumber = RandomGenerator.generateNumber();
            int secondNumber = RandomGenerator.generateNumber();

            int answer = calculateDivisor(firstNumber, secondNumber);

            questions[i] = firstNumber + " " + secondNumber;
            correctAnswers[i] = String.valueOf(answer);
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static int calculateDivisor(int firstNumber, int secondNumber) {
       while (secondNumber != 0) {
           int temp = firstNumber % secondNumber;
           firstNumber = secondNumber;
           secondNumber = temp;
       }
       return firstNumber;
    }
}
