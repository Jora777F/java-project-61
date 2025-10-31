package hexlet.code.engine;

import java.util.Scanner;

public class Engine {

    public static void runGame(String[] questions, String[] correctAnswers, String userName, Scanner scanner) {
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

            System.out.println("'" + answer + "' is wrong answer ;(. " +
                    "Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
            return;
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
