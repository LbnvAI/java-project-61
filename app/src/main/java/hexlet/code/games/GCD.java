package hexlet.code.games;

import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.setCorrectAnswer;

public class GCD {

    // Use is to run game from engine
    public static void run() {
        greetings();
        System.out.println("Find the greatest common divisor of given numbers.");
        runGame();
    }

    // Generate random task for gamer
    public static String generateTask() {
        int firstNumberMaxValue = 30;
        int secondNumberMaxValue = 30;
        int firstNumber = (int) (Math.random() * firstNumberMaxValue);
        int secondNumber = (int) (Math.random() * secondNumberMaxValue);
        // Fix the division by zero
        if (secondNumber == 0) {
            secondNumber = 1;
        }
        setCorrectAnswer(Integer.toString(getGCD(firstNumber, secondNumber)));
        return "Question: " + firstNumber + " " + secondNumber
                + "\nYour answer: ";
    }

    // Finds GCD of two numbers
    private static int getGCD(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : getGCD(b, a % b);
    }
}
