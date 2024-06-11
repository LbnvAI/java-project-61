package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    private static final int FIRST_NUMBER_MAX_VALUE = 30;
    private static final int SECOND_NUMBER_MAX_VALUE = 30;

    public static void run() {
        Engine.runGame(generateGameData(), GAME_RULE);
    }

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            String[] roundData = new String[2];
            int firstNumber = (int) (Math.random() * FIRST_NUMBER_MAX_VALUE);
            int secondNumber = (int) (Math.random() * SECOND_NUMBER_MAX_VALUE);
            // Fix the division by zero
            if (secondNumber == 0) {
                secondNumber = 1;
            }
            roundData[1] = Integer.toString(getGCD(firstNumber, secondNumber));
            roundData[0] = firstNumber + " " + secondNumber;
            gameData[i] = roundData;
        }
        return gameData;
    }

    // Finds GCD of two numbers
    private static int getGCD(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : getGCD(b, a % b);
    }
}
