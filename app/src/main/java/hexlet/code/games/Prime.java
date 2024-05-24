package hexlet.code.games;

import java.math.BigInteger;
import static hexlet.code.Engine.getGamerName;
import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.getRounds;
import static hexlet.code.Engine.doIfWrongAnswer;
import static hexlet.code.Engine.getGamerAnswer;

public class Prime implements Runnable {
    // Use is to run game from engine
    public void run() {
        greetings();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        primeGame();
    }

    // Prime game code
    private void primeGame() {
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
        int number = (int) (Math.random() * 51);
        BigInteger temp = BigInteger.valueOf(number);
        if (temp.isProbablePrime((int) Math.log(number))) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        return "Question: " + number + "\nYour answer: ";
    }

    private int correctAnswersCounter = 0;
    private String correctAnswer = "";
}
