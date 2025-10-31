package hexlet.code;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static final int GREET = 1;
    private static final int EXIT = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        showGameList();
        System.out.print("Your choice: ");

        int gameNumber;

        try {
            gameNumber = selectGame(scanner);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Invalid input.");
            scanner.close();
            return;
        }

        playGame(gameNumber, scanner);

        scanner.close();
    }

    private static void showGameList() {
        System.out.println(GREET + " - Greet");
        System.out.println(EXIT + " - Exit");
    }

    private static int selectGame(Scanner scanner) throws InputMismatchException {
        return scanner.nextInt();
    }

    private static void playGame(int gameNumber, Scanner scanner) {
        switch (gameNumber) {
            case GREET:
                Cli.hello(scanner);
                break;
            case EXIT:
                System.out.println("Goodbye!");
                System.exit(EXIT);
            default:
                System.out.println("Invalid game number!");
        }
    }
}
