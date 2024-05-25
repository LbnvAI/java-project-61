package hexlet.code.games;

import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.setCorrectAnswer;

public class Progression implements Runnable {

    // Use is to run game from engine
    public void run() {
        greetings();
        System.out.println("What number is missing in the progression?");
        runGame();
    }

    // Generate random task for gamer
    public static String generateTask() {
        int hidePosition = (int) (Math.random() * 10);
        int[] progression = generateProgression();
        setCorrectAnswer(Integer.toString(progression[hidePosition]));
        StringBuilder task = new StringBuilder("Question: ");
        for (int i = 0; i < progression.length; i++) {
            if (i == hidePosition) {
                task.append(".. ");
            } else {
                task.append(progression[i]).append(" ");
            }
        }
        task.append("\nYour answer: ");
        return task.toString();
    }

    // Generate random arithmetic progression
    // With random first element and random step
    private static int[] generateProgression() {
        int step = 1 + (int) (Math.random() * 31);
        int firstElement = (int) (Math.random() * 31);
        int[] result = new int[10];
        result[0] = firstElement;
        for (int i = 1; i < 10; i++) {
            result[i] = result[i - 1] + step;
        }
        return result;
    }
}
