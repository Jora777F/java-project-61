package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

public class GreatestCommonDivisor {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void search() {
        String gameDescription = "Find the greatest common divisor of given numbers.";

        int iterations = Engine.getNumberIterations();

        String[][] questionAndAnswers = new String[iterations][2];

        for (int i = 0; i < iterations; i++) {
            int firstNumber = RandomGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = RandomGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER);

            int answer = calculateDivisor(firstNumber, secondNumber);

            questionAndAnswers[i][0] = firstNumber + " " + secondNumber;
            questionAndAnswers[i][1] = String.valueOf(answer);
        }

        Engine.runGame(gameDescription, questionAndAnswers);
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
