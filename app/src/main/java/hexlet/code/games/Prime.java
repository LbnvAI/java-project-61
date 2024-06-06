package hexlet.code.games;

import hexlet.code.Engine;
import java.math.BigInteger;

public class Prime {

    private static final int MAX_NUMBER_VALUE = 101;

    public static void run() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Engine.runGame(generateGameData());
    }

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            String[] roundData = new String[2];
            int number = (int) (Math.random() * MAX_NUMBER_VALUE);
            BigInteger temp = BigInteger.valueOf(number);
            if (temp.isProbablePrime((int) Math.log(number))) {
                roundData[1] = "yes";
            } else {
                roundData[1] = "no";
            }
            if (number == 0 || number == 1) {
                roundData[1] = "no";
            }
            roundData[0] = "Question: " + number + "\nYour answer: ";
            gameData[i] = roundData;
        }
        return gameData;
    }
}
