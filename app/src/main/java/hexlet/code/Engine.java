package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import java.util.Scanner;


public class Engine {

    // Print list of games and keys to choose
    public static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
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
            game = new Even();
        }
        if (choice.equals("3")) {
            game = new Calc();
        }
        if (game != null) {
            game.run();
        }
    }

    // Allow user to make input
    public static String getGamerAnswer() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void doIfWrongAnswer(String gamerAnswer, String correctAnswer) {
        System.out.print("'" + gamerAnswer + "'" + " is wrong answer ;(. ");
        System.out.println("Correct answer was " + "'" + correctAnswer + "'.");
        System.out.println("Let's try again, " + getGamerName() + "!");
    }

    private static String gamerName;
    private static final int ROUNDS = 3;

    public static int getRounds() {
        return ROUNDS;
    }

    public static String getGamerName() {
        return gamerName;
    }
}
