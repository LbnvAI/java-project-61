package hexlet.code.games;

import static hexlet.code.Engine.getRounds;
import static hexlet.code.Engine.getGamerName;
import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.getGamerAnswer;

// Class for game in which your task is
// Guess the even or odd number shown on the screen
public class Even implements Runnable {

    // Use to run OddEven-game in start menu
    public void run() {
        greetings();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        evenGame();
    }

    // OddEven-game
    // 3 correct answers = you win
    // 1 wrong answer = you loose
    private void evenGame() {
        while (true) {

            // Generate pseudorandom number in bound 0-99
            int randomNumber = 1 + (int) (Math.random() * 100);

            // Print questions and get gamer answers
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            gamerAnswer = getGamerAnswer();

            // Check gamer answer
            boolean check = checkGamerAnswer(gamerAnswer, randomNumber);
            if (check) {
                doIfCorrect();
            } else {
                doIfWrong();
                break;
            }

            // In case of 3 correct answers you win and stop game
            if (correctAnswersCounter == getRounds()) {
                System.out.println("Congratulations, " + getGamerName() + "!");
                break;
            }
        }
    }

    // If answer is correct inc counter and print message and finish game
    private void doIfCorrect() {
        System.out.println("Correct!");
        correctAnswersCounter++;
    }

    // If answer is wrong print message
    private void doIfWrong() {
        System.out.println("'" + gamerAnswer + "'"
                + " is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'.");
        System.out.println("Let's try again, " + getGamerName() + "!");
    }

    private boolean checkGamerAnswer(String answer, int number) {
        if (number % 2 == 0) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        return answer.equals(correctAnswer);
    }

    private String gamerAnswer;
    private int correctAnswersCounter = 0;
    private String correctAnswer;
}
