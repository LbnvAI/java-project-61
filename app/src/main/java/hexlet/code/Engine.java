package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;

public class Engine {

    // Print list of games and keys to choose
    public static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    // Print greeting message, ask gamer name and save it
    public static void greetings() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scan = new Scanner(System.in);
        System.out.print("May I have your name? ");
        gamerName = scan.nextLine();
        System.out.println("Hello, " + gamerName + "!");
    }

    // Create and run different games depending on the player's mainMenuChoice
    public static void runGameByChoice() {
        Scanner scan = new Scanner(System.in);
        mainMenuChoice = scan.nextLine();
        System.out.println();
        if (mainMenuChoice.equals("1")) {
            greetings();
        }
        if (mainMenuChoice.equals("2")) {
            Even.run();
        }
        if (mainMenuChoice.equals("3")) {
            Calc.run();
        }
        if (mainMenuChoice.equals("4")) {
            GCD.run();
        }
        if (mainMenuChoice.equals("5")) {
            Progression.run();
        }
        if (mainMenuChoice.equals("6")) {
            Prime.run();
        }
    }

    // Perform main functionality of any game:
    //  Create and print tasks
    //  Start and finish game
    //  Check answers
    //  Print special messages
    public static void runGame() {
        for (int i = 0; i < ROUNDS; i++) {
            printGeneratedTask();
            String gamerAnswer = getGamerAnswer();

            // Check gamer answer
            if (gamerAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                doIfWrongAnswer(gamerAnswer);
                // End game
                return;
            }
        }
        System.out.println("Congratulations, " + gamerName + "!");
    }

    // Generate random task depending on the player's mainMenuChoice
    private static void printGeneratedTask() {
        switch (mainMenuChoice) {
            case "2" -> System.out.print(Even.generateTask());
            case "3" -> System.out.print(Calc.generateTask());
            case "4" -> System.out.print(GCD.generateTask());
            case "5" -> System.out.print(Progression.generateTask());
            case "6" -> System.out.print(Prime.generateTask());
            default -> {
            }
        }
    }

    // Allow user to make input
    private static String getGamerAnswer() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    // Print special message when gamer answer was wrong
    public static void doIfWrongAnswer(String gamerAnswer) {
        System.out.print("'" + gamerAnswer + "'" + " is wrong answer ;(. ");
        System.out.println("Correct answer was " + "'" + correctAnswer + "'.");
        System.out.println("Let's try again, " + gamerName + "!");
    }

    // Game parameters
    private static String mainMenuChoice;
    private static String gamerName;
    private static final int ROUNDS = 3;
    private static String correctAnswer;

    public static void setCorrectAnswer(String value) {
        correctAnswer = value;
    }
}
