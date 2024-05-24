package hexlet.code.games;

import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.getGamerName;
import static hexlet.code.Engine.getGamerAnswer;
import static hexlet.code.Engine.doIfWrongAnswer;
import static hexlet.code.Engine.getRounds;

public class GCD implements Runnable {

    // Use is to run game from engine
    public void run() {
        greetings();
        System.out.println("Find the greatest common divisor of given numbers.");
        calcGame();
    }

    // GCD game code
    private void calcGame() {
        while (true) {
            System.out.print(generateRandomNumbers());
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
    private String generateRandomNumbers() {
        int firstNumber = (int) (Math.random() * 30);
        int secondNumber = (int) (Math.random() * 30);
        // Fix the division by zero
        if (secondNumber == 0) {
            secondNumber = 1;
        }
        correctAnswer = Integer.toString(getGCD(firstNumber, secondNumber));
        return "Question: " + firstNumber + " " + secondNumber
                + "\nYour answer: ";
    }

    // Finds GCD of two numbers
    private int getGCD(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : getGCD(b, a % b);
    }

    private int correctAnswersCounter = 0;
    private String correctAnswer = "";
}
