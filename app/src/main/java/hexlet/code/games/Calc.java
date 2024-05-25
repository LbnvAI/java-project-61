package hexlet.code.games;

public class Calc {

    public static String generateTask() {
        int firstNumber = (int) (Math.random() * FIRST_NUMBER_MAX_VALUE);
        int secondNumber = (int) (Math.random() * SECOND_NUMBER_MAX_VALUE);
        char sign = ' ';
        int rand = (int) (Math.random() * SIGN_MAX_VALUE);
        if (rand == 0) {
            sign = '+';
            correctAnswer = Integer.toString(firstNumber + secondNumber);
        }
        if (rand == 1) {
            sign = '-';
            correctAnswer = Integer.toString(firstNumber - secondNumber);
        }
        if (rand == 2) {
            sign = '*';
            correctAnswer = Integer.toString(firstNumber * secondNumber);
        }
        return "Question: " + firstNumber + " " + sign + " " + secondNumber
                + "\nYour answer: ";
    }

    public static String getTaskDescription() {
        return TASK_DESCRIPTION;
    }

    public static String getCorrectAnswer() {
        return correctAnswer;
    }

    private static String correctAnswer;
    private static final String TASK_DESCRIPTION =
            "What is the result of the expression?";
    private static final int FIRST_NUMBER_MAX_VALUE = 20;
    private static final int SECOND_NUMBER_MAX_VALUE = 20;
    private static final int SIGN_MAX_VALUE = 3;
}
