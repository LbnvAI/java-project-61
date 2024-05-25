package hexlet.code;

import java.util.Scanner;

public final class Round {

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

    public void setRoundNumber(int roundNumberValue) {
        this.roundNumber = roundNumberValue;
    }

    public void setTaskDescription(String taskDescriptionValue) {
        this.taskDescription = taskDescriptionValue;
    }

    public void setRoundTask(String roundTaskValue) {
        this.roundTask = roundTaskValue;
    }

    public void setCorrectAnswer(String correctAnswerValue) {
        this.correctAnswer = correctAnswerValue;
    }

    public void setGamerName(String nameValue) {
        this.gamerName = nameValue;
    }
}
