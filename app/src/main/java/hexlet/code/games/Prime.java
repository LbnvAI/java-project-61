package hexlet.code.games;

import java.math.BigInteger;
import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.setCorrectAnswer;


public class Prime implements Runnable {
    // Use is to run game from engine
    public void run() {
        greetings();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        runGame();
    }

    // Generate random task for gamer
    public static String generateTask() {
        int number = (int) (Math.random() * 51);
        BigInteger temp = BigInteger.valueOf(number);
        if (temp.isProbablePrime((int) Math.log(number))) {
            setCorrectAnswer("yes");
        } else {
            setCorrectAnswer("no");
        }
        return "Question: " + number + "\nYour answer: ";
    }
}
