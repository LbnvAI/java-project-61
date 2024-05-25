package hexlet.code.games;

import java.math.BigInteger;

public class Prime {

    public static String generateTask() {
        int number = (int) (Math.random() * MAX_NUMBER_VALUE);
        BigInteger temp = BigInteger.valueOf(number);
        if (temp.isProbablePrime((int) Math.log(number))) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        if (number == 0 || number == 1) {
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
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static String correctAnswer;
    private static final int MAX_NUMBER_VALUE = 101;
}
