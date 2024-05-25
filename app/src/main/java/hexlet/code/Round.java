package hexlet.code;

import java.util.Scanner;

public class Round {

    private String correctAnswer;
    private String roundTask;
    private String taskDescription;
    private int roundNumber;
    private String gamerName;

    public String run() {
        if (roundNumber == 0) {
            System.out.println(taskDescription);
        }
        System.out.println(roundTask);
        String gamerAnswer = getGamerAnswer();

        if (gamerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            doIfWrongAnswer(gamerAnswer);
            return "fail";
        }
        if (roundNumber == 2) {
            System.out.println("Congratulations, " + gamerName + "!");
        }
        return "success";
    }

    private void doIfWrongAnswer(String gamerAnswer) {
        System.out.print("'" + gamerAnswer + "'" + " is wrong answer ;(. ");
        System.out.println("Correct answer was " + "'" + correctAnswer + "'.");
        System.out.println("Let's try again, " + gamerName + "!");


    }

    private String getGamerAnswer() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setRoundTask(String roundTask) {
        this.roundTask = roundTask;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }
}
