package hexlet.code;

import java.util.Scanner;


public class MainMenu {

    // Print list of games and keys to choose
    public static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    // Print greeting message, ask gamer name and save it
    public static void greetings() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scan = new Scanner(System.in);
        System.out.print("May I have your name? ");
        gamerName = scan.nextLine();
        System.out.println("Hello, " + getGamerName() + "!");
    }

    // Create and run different games depending on the player's choice
    public static void runGameByChoice() {
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        System.out.println();
        Runnable game = null;
        if (choice.equals("1")) {
            greetings();
        }
        if (choice.equals("2")) {
            game = new OddEven();
        }
        if (game != null) {
            game.run();
        }
    }

    private static String gamerName;

    public static String getGamerName() {
        return gamerName;
    }
}
