package hexlet.code.games;

public class Progression {

    public static String generateTask() {
        int hidePosition = (int) (Math.random() * PROGRESSION_LENGTH);
        int[] progression = generateProgression();
        correctAnswer = Integer.toString(progression[hidePosition]);
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

    public static String getTaskDescription() {
        return TASK_DESCRIPTION;
    }

    public static String getCorrectAnswer() {
        return correctAnswer;
    }

    private static final String TASK_DESCRIPTION =
            "What number is missing in the progression?";
    private static String correctAnswer;
    private static final int PROGRESSION_LENGTH = 10;
    private static final int PROG_STEP_MAX_VALUE = 31;
    private static final int PROG_FIRST_ELEMENT_MAX_VALUE = 31;
}
