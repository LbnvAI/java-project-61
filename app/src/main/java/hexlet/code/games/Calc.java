package hexlet.code.games;

import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.setCorrectAnswer;

// This game create random expression using two numbers and signs "+ - *"
// Gamer task is guess the correct answer 3 times
// If gamer make 1 mistake the game is over
public class Calc {

    // Use is to run game from engine
    public static void run() {
        greetings();
        System.out.println("What is the result of the expression?");
        runGame();
    }

    // Generate random task for gamer
    public static String generateTask() {
        int firstNumber = (int) (Math.random() * FIRST_NUMBER_MAX_VALUE);
        int secondNumber = (int) (Math.random() * SECOND_NUMBER_MAX_VALUE);
        char sign = ' ';
        int rand = (int) (Math.random() * SIGN_MAX_VALUE);
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

    private static final int FIRST_NUMBER_MAX_VALUE = 20;
    private static final int SECOND_NUMBER_MAX_VALUE = 20;
    private static final int SIGN_MAX_VALUE = 3;
}
