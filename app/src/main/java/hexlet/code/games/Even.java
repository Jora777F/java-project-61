package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

public class Even {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void checkEven() {
        String gameDescription = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        int iterations = Engine.getNumberIterations();

        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];

        for (int i = 0; i < iterations; i++) {
            int randomNumber = RandomGenerator.generateNumber(MIN_VALUE, MAX_VALUE);
            questions[i] = String.valueOf(randomNumber);
            correctAnswers[i] = isEvenNumber(randomNumber) ? "yes" : "no";
        }

        Engine.runGame(gameDescription, questions, correctAnswers);
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
