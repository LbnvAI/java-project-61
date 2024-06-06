package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    private static final int FIRST_NUMBER_MAX_VALUE = 20;
    private static final int SECOND_NUMBER_MAX_VALUE = 20;
    private static final int SIGN_MAX_VALUE = 3;

    public static void run() {
        System.out.println("What is the result of the expression?");
        Engine.runGame(generateGameData());
    }

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            String[] roundData = new String[2];
            int firstNumber = (int) (Math.random() * FIRST_NUMBER_MAX_VALUE);
            int secondNumber = (int) (Math.random() * SECOND_NUMBER_MAX_VALUE);
            char sign = ' ';
            int rand = (int) (Math.random() * SIGN_MAX_VALUE);
            if (rand == 0) {
                sign = '+';
                roundData[1] = Integer.toString(firstNumber + secondNumber);
            }
            if (rand == 1) {
                sign = '-';
                roundData[1] = Integer.toString(firstNumber - secondNumber);
            }
            if (rand == 2) {
                sign = '*';
                roundData[1] = Integer.toString(firstNumber * secondNumber);
            }
            roundData[0] = "Question: " + firstNumber + " " + sign + " " + secondNumber
                    + "\nYour answer: ";
            gameData[i] = roundData;
        }
        return gameData;
    }
}
