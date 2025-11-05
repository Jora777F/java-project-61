package hexlet.code.engine;

import java.util.Scanner;

public class Engine {

    private static final int NUMBER_ITERATIONS = 3;

    public static void runGame(String gameDescription, String[] questions, String[] correctAnswers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(gameDescription);

        for (int i = 0; i < questions.length; i++) {
            String question = questions[i];
            String correctAnswer = correctAnswers[i];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");

            String answer = scanner.next();

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
                continue;
            }

            System.out.println("'" + answer + "' is wrong answer ;(. "
                    + "Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
            return;
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }

    public static int getNumberIterations() {
        return NUMBER_ITERATIONS;
    }
}
