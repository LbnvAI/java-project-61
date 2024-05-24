package hexlet.code.games;

import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.setCorrectAnswer;

// This game create random expression using two numbers and signs "+ - *"
// Gamer task is guess the correct answer 3 times
// If gamer make 1 mistake the game is over
public class Calc implements Runnable {

    // Use is to run game from engine
    public void run() {
        greetings();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        runGame();
    }

    // Generate random task for gamer
    public static String generateTask() {
        int firstNumber = (int) (Math.random() * 20);
        int secondNumber = (int) (Math.random() * 20);
        char sign = ' ';
        int rand = (int) (Math.random() * 3);
        if (rand == 0) {
            sign = '+';
            setCorrectAnswer(Integer.toString(firstNumber + secondNumber));
        }
        if (rand == 1) {
            sign = '-';
            setCorrectAnswer(Integer.toString(firstNumber - secondNumber));
        }
        if (rand == 2) {
            sign = '*';
            setCorrectAnswer(Integer.toString(firstNumber * secondNumber));
        }
        return "Question: " + firstNumber + " " + sign + " " + secondNumber
                + "\nYour answer: ";
    }
}
