package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER_VALUE = 100;

    public static void run() {
        Engine.runGame(generateGameData(), GAME_RULE);
    }

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            String[] roundData = new String[2];
            int number = (int) (Math.random() * MAX_NUMBER_VALUE);
            if (number % 2 == 0) {
                roundData[1] = "yes";
            } else {
                roundData[1] = "no";
            }
            roundData[0] = Integer.toString(number);
            gameData[i] = roundData;
        }
        return gameData;
    }
}
