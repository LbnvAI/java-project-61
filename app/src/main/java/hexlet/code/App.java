package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        printMenu();
        runGameByChoice();
    }

    public static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    public static void runGameByChoice() {
        Scanner scan = new Scanner(System.in);
        Engine.setMainMenuChoice(scan.nextLine());
        System.out.println();
        if (Engine.getMainMenuChoice().equals("1")) {
            Engine.greetings();
        } else if (!Engine.getMainMenuChoice().equals("0")) {
            Engine.runGame();
        }
    }
}
