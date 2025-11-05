package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

public class Progression {

    private static final int SEQUENCE_LENGTH = 10;

    private static final int MIN_INDEX = 0;
    private static final int MAX_INDEX = 9;

    private static final int MIN_INITIAL_TERM = 1;
    private static final int MAX_INITIAL_TERM = 100;

    private static final int MIN_COMMON_DIFF = 1;
    private static final int MAX_COMMON_DIFF = 100;

    public static void run() {
        String gameDescription = "What number is missing in the progression?";

        int iterations = Engine.getNumberIterations();

        String[][] questionAndAnswers = new String[iterations][2];

        for (int i = 0; i < iterations; i++) {
            int initialTerm = RandomGenerator.generateNumber(MIN_INITIAL_TERM, MAX_INITIAL_TERM);
            int commonDiff = RandomGenerator.generateNumber(MIN_COMMON_DIFF, MAX_COMMON_DIFF);

            String[] sequence = makeProgression(initialTerm, commonDiff, SEQUENCE_LENGTH);

            int unknownTermIndex = RandomGenerator.generateNumber(MIN_INDEX, MAX_INDEX);
            questionAndAnswers[i][1] = sequence[unknownTermIndex];

            sequence[unknownTermIndex] = "..";
            questionAndAnswers[i][0] = String.join(" ", sequence);
        }

        Engine.runGame(gameDescription, questionAndAnswers);
    }

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];

        for (int i = 0; i < length; i++) {
            progression[i] = Integer.toString(first + i * step);
        }

        return progression;
    }
}
