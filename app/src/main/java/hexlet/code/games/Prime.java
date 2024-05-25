package hexlet.code.games;

import java.math.BigInteger;
import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.setCorrectAnswer;


public class Prime {
    // Use is to run game from engine
    public static void run() {
        greetings();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        runGame();
    }

    // Generate random task for gamer
    public static String generateTask() {
        int maxNumberValue = 101;
        int number = (int) (Math.random() * maxNumberValue);
        BigInteger temp = BigInteger.valueOf(number);
        if (temp.isProbablePrime((int) Math.log(number))) {
            setCorrectAnswer("yes");
        } else {
            setCorrectAnswer("no");
        }
        return "Question: " + number + "\nYour answer: ";
    }
}
