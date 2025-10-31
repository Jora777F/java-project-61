package hexlet.code;

import hexlet.code.games.Even;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static final int GREET = 1;
    private static final int EVEN = 2;
    private static final int EXIT = 0;

    private static final int NUMBER_ITERATIONS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        showGameList();
        System.out.print("Your choice: ");

        int gameNumber;

        try {
            gameNumber = inputGameNumber(scanner);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Invalid input.");
            scanner.close();
            return;
        }

        String userName = sayHello(scanner);
        playGame(gameNumber, scanner, userName);

        scanner.close();
    }

    private static void showGameList() {
        System.out.println(GREET + " - Greet");
        System.out.println(EVEN + " - Even");
        System.out.println(EXIT + " - Exit");
    }

    private static int inputGameNumber(Scanner scanner) throws InputMismatchException {
        return scanner.nextInt();
    }

    public static String sayHello(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");

        return name;
    }

    private static void playGame(int gameNumber, Scanner scanner, String userName) {
        switch (gameNumber) {
            case EVEN:
                Even.checkEven(NUMBER_ITERATIONS, scanner, userName);
                break;
            case EXIT:
                System.out.println("Goodbye!");
                System.exit(EXIT);
            default:
                System.out.println("Invalid game number!");
        }
    }
}
