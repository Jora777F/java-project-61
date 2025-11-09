package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

public class Even {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void run() {
        String gameDescription = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[][] questionsAndAnswers = new String[Engine.ROUNDS][2];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int randomNumber = RandomGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER);
            questionsAndAnswers[i][0] = String.valueOf(randomNumber);
            questionsAndAnswers[i][1] = isEvenNumber(randomNumber) ? "yes" : "no";
        }

        Engine.runGame(gameDescription, questionsAndAnswers);
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
