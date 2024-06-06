package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {

    private static final int PROGRESSION_LENGTH = 10;
    private static final int PROG_STEP_MAX_VALUE = 31;
    private static final int PROG_FIRST_ELEMENT_MAX_VALUE = 31;

    public static void run() {
        System.out.println("What number is missing in the progression?");
        Engine.runGame(generateGameData());
    }

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            String[] roundData = new String[2];
            int hidePosition = (int) (Math.random() * PROGRESSION_LENGTH);
            int[] progression = generateProgression();
            roundData[1] = Integer.toString(progression[hidePosition]);
            StringBuilder task = new StringBuilder("Question: ");
            for (int j = 0; j < PROGRESSION_LENGTH; j++) {
                if (j == hidePosition) {
                    task.append(".. ");
                } else {
                    task.append(progression[j]).append(" ");
                }
            }
            task.append("\nYour answer: ");
            roundData[0] = task.toString();
            gameData[i] = roundData;
        }
        return gameData;
    }

    private static int[] generateProgression() {
        int step = 1 + (int) (Math.random() * PROG_STEP_MAX_VALUE);
        int firstElement = (int) (Math.random() * PROG_FIRST_ELEMENT_MAX_VALUE);
        int[] result = new int[PROGRESSION_LENGTH];
        result[0] = firstElement;
        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            result[i] = result[i - 1] + step;
        }
        return result;
    }
}
