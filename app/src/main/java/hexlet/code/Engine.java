package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;

public class Engine {

    public static void greetings() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scan = new Scanner(System.in);
        System.out.print("May I have your name? ");
        gamerName = scan.nextLine();
        System.out.println("Hello, " + gamerName + "!");
    }


    public static void runGame() {
        greetings();
        for (int i = 0; i < ROUNDS; i++) {
            configureRound();
            if (runRound(i).equals("fail")) {
                break;
            }
        }
    }

    public static void configureRound() {
        switch (mainMenuChoice) {
            case "2" -> {
                taskDescription = Even.getTaskDescription();
                roundTask = Even.generateTask();
                correctAnswer = Even.getCorrectAnswer();
            }
            case "3" -> {
                taskDescription = Calc.getTaskDescription();
                roundTask = Calc.generateTask();
                correctAnswer = Calc.getCorrectAnswer();
            }
            case "4" -> {
                taskDescription = GCD.getTaskDescription();
                roundTask = GCD.generateTask();
                correctAnswer = GCD.getCorrectAnswer();
            }
            case "5" -> {
                taskDescription = Progression.getTaskDescription();
                roundTask = Progression.generateTask();
                correctAnswer = Progression.getCorrectAnswer();
            }
            case "6" -> {
                taskDescription = Prime.getTaskDescription();
                roundTask = Prime.generateTask();
                correctAnswer = Prime.getCorrectAnswer();
            }
            default -> {
            }
        }
    }

    public static String runRound(int roundNumber) {
        if (roundNumber == 0) {
            System.out.println(taskDescription);
        }
        System.out.print(roundTask);
        String gamerAnswer = getGamerAnswer();

        if (gamerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            doIfWrongAnswer(gamerAnswer);
            return "fail";
        }
        if (roundNumber == 2) {
            System.out.println("Congratulations, " + gamerName + "!");
        }
        return "success";
    }

    private static void doIfWrongAnswer(String gamerAnswer) {
        System.out.print("'" + gamerAnswer + "'" + " is wrong answer ;(. ");
        System.out.println("Correct answer was " + "'" + correctAnswer + "'.");
        System.out.println("Let's try again, " + gamerName + "!");


    }

    private static String getGamerAnswer() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void setMainMenuChoice(String mainMenuChoiceValue) {
        Engine.mainMenuChoice = mainMenuChoiceValue;
    }

    public static String getMainMenuChoice() {
        return mainMenuChoice;
    }

    private static String mainMenuChoice;
    private static String correctAnswer;
    private static String roundTask;
    private static String taskDescription;
    private static String gamerName;
    private static final int ROUNDS = 3;
}
