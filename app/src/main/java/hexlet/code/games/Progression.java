package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.util.RandomGenerator;

import java.util.Scanner;

public class Progression {

    private static final int SEQUENCE_LENGTH = 10;

    private static final int BEGIN = 0;
    private static final int END = 9;

    public static void arithmeticProgression(int iterations, Scanner scanner, String userName) {
        System.out.println("What number is missing in the progression?");

        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];

        for (int i = 0; i < iterations; i++) {
            String[] sequence = generateSequence();

            int unknownTermIndex = RandomGenerator.generateNumber(BEGIN, END);
            correctAnswers[i] = sequence[unknownTermIndex];

            sequence[unknownTermIndex] = "..";
            questions[i] = String.join(" ", sequence);
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static String[] generateSequence() {

        int initialTerm = RandomGenerator.generateNumber();
        int commonDiff = RandomGenerator.generateNumber();

        String[] sequence = new String[SEQUENCE_LENGTH];

        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            int term = calculateSequenceTerm(initialTerm, commonDiff, i);
            sequence[i] = String.valueOf(term);
        }

        return sequence;
    }

    private static int calculateSequenceTerm(int initialTerm, int commonDiff, int n) {
        return initialTerm + (n - 1) * commonDiff;
    }

}
