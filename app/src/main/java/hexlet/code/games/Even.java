package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.getRoundCount;
import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.getGamerName;

// Class for game in which your task is
// Guess the even or odd number shown on the screen
public class Even implements Runnable {

    // Use to run OddEven-game in start menu
    public void run() {
        greetings();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        oddEvenGame();
    }

    // OddEven-game
    // 3 correct answers = you win
    // 1 wrong answer = you loose
    private void oddEvenGame() {

        int correctAnswersCounter = 0;
        while (true) {

            // Generate pseudorandom number in bound 0-99
            int randomNumber = 1 + (int) (Math.random() * 100);

            // Create variables to simplify checks
            String correctAnswer;
            if (randomNumber % 2 == 0) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }

            // Print questions and get gamer answers
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            Scanner scan = new Scanner(System.in);
            String gamerAnswer = scan.nextLine();

            // Check gamer answer
            if (gamerAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCounter++;
            } else {
                // In case of 1 wrong answer you loose and stop game
                System.out.println("'" + gamerAnswer + "'"
                        + " is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'.");
                System.out.println("Let's try again, " + getGamerName() + "!");
                break;
            }
            // In case of 3 correct answers you win and stop game
            if (correctAnswersCounter == getRoundCount()) {
                System.out.println("Congratulations, " + getGamerName() + "!");
                break;
            }
        }
    }
}
