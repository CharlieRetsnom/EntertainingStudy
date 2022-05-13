package ru.efimovpavel.entertainigstudy.Models;

import java.io.Serializable;

public class Problem implements Serializable {
    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Problem(){}
    public String taskText;
    public String checkSolved;
    private String answer;
   public Problem(String taskText, String answer){
       this.taskText=taskText;
       this.answer=answer;
   }
   public boolean isCorrectAnswer(String answer){
        return answer.equals(this.answer);
   }




}
