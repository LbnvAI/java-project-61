package hexlet.code.games;

import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.setCorrectAnswer;

public class Progression {

    // Use is to run game from engine
    public static void run() {
        greetings();
        System.out.println("What number is missing in the progression?");
        runGame();
    }

    // Generate random task for gamer
    public static String generateTask() {
        int hidePosition = (int) (Math.random() * PROGRESSION_LENGTH);
        int[] progression = generateProgression();
        setCorrectAnswer(Integer.toString(progression[hidePosition]));
        StringBuilder task = new StringBuilder("Question: ");
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
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
        int progressionMaxStepSize = 31;
        int progFirstElementMaxValue = 31;
        int step = 1 + (int) (Math.random() * progressionMaxStepSize);
        int firstElement = (int) (Math.random() * progFirstElementMaxValue);
        int[] result = new int[PROGRESSION_LENGTH];
        result[0] = firstElement;
        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            result[i] = result[i - 1] + step;
        }
        return result;
    }

    private static final int PROGRESSION_LENGTH = 10;
}
