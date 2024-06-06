package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    private static final int MAX_NUMBER_VALUE = 100;

    public static void run() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.runGame(generateGameData());
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
            roundData[0] = "Question: " + number + "\nYour answer: ";
            gameData[i] = roundData;
        }
        return gameData;
    }
}
