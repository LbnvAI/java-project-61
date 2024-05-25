package hexlet.code.games;

public class GCD {

    public static String generateTask() {
        int firstNumber = (int) (Math.random() * FIRST_NUMBER_MAX_VALUE);
        int secondNumber = (int) (Math.random() * SECOND_NUMBER_MAX_VALUE);
        // Fix the division by zero
        if (secondNumber == 0) {
            secondNumber = 1;
        }
        correctAnswer = Integer.toString(getGCD(firstNumber, secondNumber));
        return "Question: " + firstNumber + " " + secondNumber
                + "\nYour answer: ";
    }

    // Finds GCD of two numbers
    private static int getGCD(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : getGCD(b, a % b);
    }

    public static String getTaskDescription() {
        return TASK_DESCRIPTION;
    }

    public static String getCorrectAnswer() {
        return correctAnswer;
    }

    private static final String TASK_DESCRIPTION =
            "Find the greatest common divisor of given numbers.";
    private static String correctAnswer;
    private static final int FIRST_NUMBER_MAX_VALUE = 30;
    private static final int SECOND_NUMBER_MAX_VALUE = 30;
}
