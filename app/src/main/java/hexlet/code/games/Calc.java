package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    private static final String GAME_RULE = "What is the result of the expression?";
    private static final int FIRST_NUMBER_MAX_VALUE = 20;
    private static final int SECOND_NUMBER_MAX_VALUE = 20;
    private static final int SIGN_MAX_VALUE = 3;
    private static final char[] SIGNS = {'+', '-', '*'};

    public static void run() {
        Engine.runGame(generateGameData(), GAME_RULE);
    }

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            String[] roundData = new String[2];
            int firstNumber = (int) (Math.random() * FIRST_NUMBER_MAX_VALUE);
            int secondNumber = (int) (Math.random() * SECOND_NUMBER_MAX_VALUE);
            int rand = (int) (Math.random() * SIGN_MAX_VALUE);
            roundData[1] = calculate(SIGNS[rand], firstNumber, secondNumber);
            roundData[0] = firstNumber + " " + SIGNS[rand] + " " + secondNumber;
            gameData[i] = roundData;
        }
        return gameData;
    }

    private static String calculate(char sign, int firstNumber, int secondNumber) {
        if (sign == '+') {
            return Integer.toString(firstNumber + secondNumber);
        } else if (sign == '-') {
            return Integer.toString(firstNumber - secondNumber);
        } else if (sign == '*') {
            return Integer.toString(firstNumber * secondNumber);
        } else {
            return "";
        }
    }
}
