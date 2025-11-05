package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

public class Calculator {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void run() {
        String gameDescription = "What is the result of the expression?";

        int iterations = Engine.getNumberIterations();

        String[][] questionAndAnswers = new String[iterations][2];

        for (int i = 0; i < iterations; i++) {
            int firstOperand = RandomGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER);
            int secondOperand = RandomGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER);

            int operationIndex = RandomGenerator.generateNumber(0, OPERATIONS.length - 1);
            char operation = OPERATIONS[operationIndex].charAt(0);

            questionAndAnswers[i][0] = firstOperand + " " + operation + " " + secondOperand;

            int answer = calculate(firstOperand, secondOperand, operation);
            questionAndAnswers[i][1] = String.valueOf(answer);
        }

        Engine.runGame(gameDescription, questionAndAnswers);
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
