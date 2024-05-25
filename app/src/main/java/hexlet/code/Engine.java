package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;

public class Engine {

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

    public static void greetings() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scan = new Scanner(System.in);
        System.out.print("May I have your name? ");
        gamerName = scan.nextLine();
        System.out.println("Hello, " + gamerName + "!");
    }

    public static void runGameByChoice() {
        Scanner scan = new Scanner(System.in);
        mainMenuChoice = scan.nextLine();
        System.out.println();
        switch (mainMenuChoice) {
            case "1" -> greetings();
            case "2", "3", "4", "5", "6", "0" -> {
                greetings();
                runGame();
            }
            default -> {
            }
        }
    }

    private static void runGame() {
        Round round = new Round();
        for (int roundNumber = 0; roundNumber < ROUNDS; roundNumber++) {
            configureRound(round, roundNumber);
            if (round.run().equals("fail")) {
                break;
            }
        }
    }

    private static void configureRound(Round round, int roundNumber) {
        round.setRoundNumber(roundNumber);
        round.setGamerName(gamerName);
        switch (mainMenuChoice) {
            case "2" -> {
                round.setTaskDescription(Even.getTaskDescription());
                round.setRoundTask(Even.generateTask());
                round.setCorrectAnswer(Even.getCorrectAnswer());
            }
            case "3" -> {
                round.setTaskDescription(Calc.getTaskDescription());
                round.setRoundTask(Calc.generateTask());
                round.setCorrectAnswer(Calc.getCorrectAnswer());
            }
            case "4" -> {
                round.setTaskDescription(GCD.getTaskDescription());
                round.setRoundTask(GCD.generateTask());
                round.setCorrectAnswer(GCD.getCorrectAnswer());
            }
            case "5" -> {
                round.setTaskDescription(Progression.getTaskDescription());
                round.setRoundTask(Progression.generateTask());
                round.setCorrectAnswer(Progression.getCorrectAnswer());
            }
            case "6" -> {
                round.setTaskDescription(Prime.getTaskDescription());
                round.setRoundTask(Prime.generateTask());
                round.setCorrectAnswer(Prime.getCorrectAnswer());
            }
            default -> {
            }
        }
    }

    private static String mainMenuChoice;
    private static String gamerName;
    private static final int ROUNDS = 3;
}
