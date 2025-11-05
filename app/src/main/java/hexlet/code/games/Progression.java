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

    public static void arithmeticProgression() {
        String gameDescription = "What number is missing in the progression?";

        int iterations = Engine.getNumberIterations();

        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];

        for (int i = 0; i < iterations; i++) {
            String[] sequence = generateSequence();

            int unknownTermIndex = RandomGenerator.generateNumber(MIN_INDEX, MAX_INDEX);
            correctAnswers[i] = sequence[unknownTermIndex];

            sequence[unknownTermIndex] = "..";
            questions[i] = String.join(" ", sequence);
        }

        Engine.runGame(gameDescription, questions, correctAnswers);
    }

    private static String[] generateSequence() {

        int initialTerm = RandomGenerator.generateNumber(MIN_INITIAL_TERM, MAX_INITIAL_TERM);
        int commonDiff = RandomGenerator.generateNumber(MIN_COMMON_DIFF, MAX_COMMON_DIFF);

        String[] sequence = new String[SEQUENCE_LENGTH];

        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            int term = calculateSequenceTerm(initialTerm, commonDiff, i);
            sequence[i] = String.valueOf(term);
        }

        return sequence;
    }

    /**
     * Вычисление элемента последовательности.
     * @param initialTerm начальный элемент
     * @param commonDiff шаг
     * @param n индекс
     * @return элемент последовательности
     */
    private static int calculateSequenceTerm(int initialTerm, int commonDiff, int n) {
        return initialTerm + (n - 1) * commonDiff;
    }

}
