package hexlet.code.games;

import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.setCorrectAnswer;

// Class for game in which your task is
// Guess the even or odd number shown on the screen
public class Even implements Runnable {

    // Use to run OddEven-game in start menu
    public void run() {
        greetings();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        runGame();
    }

    // Generate random task for gamer
    public static String generateTask() {
        int number = (int) (Math.random() * 100);
        if (number % 2 == 0) {
            setCorrectAnswer("yes");
        } else {
            setCorrectAnswer("no");
        }
        return "Question: " + number + "\nYour answer: ";
    }
}
