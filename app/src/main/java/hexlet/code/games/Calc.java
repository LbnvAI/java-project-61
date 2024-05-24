package hexlet.code.games;

import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.getGamerAnswer;
import static hexlet.code.Engine.doIfWrongAnswer;
import static hexlet.code.Engine.getRounds;
import static hexlet.code.Engine.getGamerName;

// This game create random expression using two numbers and signs "+ - *"
// Gamer task is guess the correct answer 3 times
// If gamer make 1 mistake the game is over
public class Calc implements Runnable {

    // Use is to run game from engine
    public void run() {
        greetings();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        calcGame();
    }

    // Calc game code
    private void calcGame() {
        while (true) {
            System.out.print(generateTask());
            String gamerAnswer = getGamerAnswer();

            // Check gamer answer
            if (gamerAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCounter++;
            } else {
                doIfWrongAnswer(gamerAnswer, correctAnswer);
                // End game
                break;
            }

            // In case of 3 correct answers you win and stop game
            if (correctAnswersCounter == getRounds()) {
                System.out.println("Congratulations, " + getGamerName() + "!");
                break;
            }
        }
    }

    // Generate random task for gamer
    private String generateTask() {
        int firstNumber = (int) (Math.random() * 20);
        int secondNumber = (int) (Math.random() * 20);
        char sign = ' ';
        int rand = (int) (Math.random() * 3);
        if (rand == 0) {
            sign = '+';
            correctAnswer = Integer.toString(firstNumber + secondNumber);
        }
        if (rand == 1) {
            sign = '-';
            correctAnswer = Integer.toString(firstNumber - secondNumber);
        }
        if (rand == 2) {
            sign = '*';
            correctAnswer = Integer.toString(firstNumber * secondNumber);
        }
        return "Question: " + firstNumber + " " + sign + " " + secondNumber
                + "\nYour answer: ";
    }

    private int correctAnswersCounter = 0;
    private String correctAnswer = "";
}
