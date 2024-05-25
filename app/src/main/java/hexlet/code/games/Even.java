package hexlet.code.games;

public class Even {

    // Generate random task for gamer
    public static String generateTask() {
        int number = (int) (Math.random() * MAX_NUMBER_VALUE);
        if (number % 2 == 0) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        return "Question: " + number + "\nYour answer: ";
    }

    public static String getTaskDescription() {
        return TASK_DESCRIPTION;
    }

    public static String getCorrectAnswer() {
        return correctAnswer;
    }

    private static final String TASK_DESCRIPTION =
            "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static String correctAnswer;
    private static final int MAX_NUMBER_VALUE = 100;
}
