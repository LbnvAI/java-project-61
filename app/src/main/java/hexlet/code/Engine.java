package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static String gamerName;
    public static final int ROUNDS = 3;

    public static void greetings() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scan = new Scanner(System.in);
        System.out.print("May I have your name? ");
        gamerName = scan.nextLine();
        System.out.println("Hello, " + gamerName + "!");
    }

    public static void runGame(String[][] gameData, String gameRule) {
        greetings();
        Scanner scan = new Scanner(System.in);
        String gamerAnswer;
        System.out.println(gameRule);
        for (int i = 0; i < ROUNDS; i++) {
            System.out.print("Question: " + gameData[i][0] + "\nYour answer: ");
            gamerAnswer = scan.nextLine();
            if (gamerAnswer.equals(gameData[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + gamerAnswer + "'" + " is wrong answer ;(. ");
                System.out.println("Correct answer was " + "'" + gameData[i][1] + "'.");
                System.out.println("Let's try again, " + gamerName + "!");
                break;
            }
            if (i == ROUNDS - 1) {
                System.out.println("Congratulations, " + gamerName + "!");
            }
        }
    }
}
