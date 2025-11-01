package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

import java.util.Scanner;

public class Calculator {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';

    public static void run(int iterations, Scanner scanner, String userName) {
        System.out.println("What is the result of the expression?");

        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];

        for (int i = 0; i < iterations; i++) {
            int firstOperand = RandomGenerator.generateNumber();
            int secondOperand = RandomGenerator.generateNumber();
            char operation = chooseRandomOperation();

            questions[i] = firstOperand + " " + operation + " " + secondOperand;

            int answer = calculate(firstOperand, secondOperand, operation);
            correctAnswers[i] = String.valueOf(answer);
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static char chooseRandomOperation() {
        String[] operations = {"+", "-", "*"};

        int min = 0;
        int max = 2;
        int index = RandomGenerator.generateNumber(min, max);

        String currentOperation = operations[index];

        return currentOperation.charAt(0);
    }

    public static int calculate(int firstOperand, int secondOperand, char operation) {
        return switch (operation) {
            case ADDITION -> firstOperand + secondOperand;
            case SUBTRACTION -> firstOperand - secondOperand;
            case MULTIPLICATION -> firstOperand * secondOperand;
            default -> 0;
        };
    }
}
