package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GreatestCommonDivisor;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static final int GREET = 1;
    private static final int EVEN = 2;
    private static final int CALCULATOR = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;
    private static final int EXIT = 0;

    private static final int NUMBER_ITERATIONS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        showGameList();
        System.out.print("Your choice: ");

        int gameNumber;

        try {
            gameNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Invalid input.");
            scanner.close();
            return;
        }

        System.out.println();

        if (gameNumber == EXIT) {
            System.out.println("Goodbye!");
            scanner.close();
            return;
        }

        if (gameNumber == GREET) {
            System.out.println("Welcome to the Brain Games!");
            System.out.print("May I have your name? ");
            String userName = scanner.next();
            System.out.println("Hello, " + userName + "!");
            scanner.close();
            return;
        }

        playGame(gameNumber);

        scanner.close();
    }

    private static void showGameList() {
        System.out.println(GREET + " - Greet");
        System.out.println(EVEN + " - Even");
        System.out.println(CALCULATOR + " - Calc");
        System.out.println(GCD + " - GCD");
        System.out.println(PROGRESSION + " - Progression");
        System.out.println(PRIME + " - Prime");
        System.out.println(EXIT + " - Exit");
    }

    private static void playGame(int gameNumber) {
        switch (gameNumber) {
            case GREET:
                break;
            case EVEN:
                Even.checkEven();
                break;
            case CALCULATOR:
                Calculator.run();
                break;
            case GCD:
                GreatestCommonDivisor.search();
                break;
            case PROGRESSION:
                Progression.arithmeticProgression();
                break;
            case PRIME:
                Prime.checkPrime();
                break;
            default:
                System.out.println("Unknown user choice: " + gameNumber);
        }
    }
}
