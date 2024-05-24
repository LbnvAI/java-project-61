package hexlet.code.games;

import static hexlet.code.Engine.getRounds;
import static hexlet.code.Engine.greetings;
import static hexlet.code.Engine.getGamerAnswer;
import static hexlet.code.Engine.doIfWrongAnswer;
import static hexlet.code.Engine.getGamerName;

public class Progression implements Runnable {

    // Use is to run game from engine
    public void run() {
        greetings();
        System.out.println("What number is missing in the progression?");
        progressionGame();
    }

    // Progression game code
    private void progressionGame() {
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
        int hidePosition = (int) (Math.random() * 11);
        int[] progression = generateProgression();
        correctAnswer = Integer.toString(progression[hidePosition]);

        StringBuilder task = new StringBuilder("Question: ");
        for (int i = 0; i < hidePosition; i++) {
            task.append(progression[i]).append(" ");
        }
        task.append(".. ");
        for (int i = hidePosition+1; i < progression.length; i++) {
            task.append(progression[i]).append(" ");
        }
        task.append("\nYour answer: ");
        return task.toString();
    }

    // Generate random arithmetic progression
    // With random first element and random step
    private int[] generateProgression() {
        int step = (int) (Math.random() * 30);
        int firstElement = (int) (Math.random() * 30);
        int[] result = new int[10];
        result[0] = firstElement;
        for (int i = 1; i < 10; i++) {
            result[i] = result[i - 1] + step;
        }
        return result;
    }

    private int correctAnswersCounter = 0;
    private String correctAnswer = "";
}
