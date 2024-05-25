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
        int firstNumberMaxValue = 20;
        int secondNumberMaxValue = 20;
        int signRandomValue = 3;
        int firstNumber = (int) (Math.random() * firstNumberMaxValue);
        int secondNumber = (int) (Math.random() * secondNumberMaxValue);
        char sign = ' ';
        int rand = (int) (Math.random() * signRandomValue);
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
