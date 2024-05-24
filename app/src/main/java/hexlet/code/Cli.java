package hexlet.code;

import java.util.Scanner;


public class Cli {

    public static void greetings() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scan = new Scanner(System.in);
        System.out.print("May I have your name? ");
        gamerName = scan.nextLine();
        System.out.println("Hello, " + getGamerName() + "!");
    }

    private static String gamerName;

    public static String getGamerName() {
        return gamerName;
    }
}
