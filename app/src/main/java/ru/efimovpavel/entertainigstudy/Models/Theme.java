package ru.efimovpavel.entertainigstudy.Models;

import java.io.Serializable;

public class Theme implements Serializable {
    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public Problem[] getProblems() {
        return problems;
    }

    public void setProblems(Problem[] problems) {
        this.problems = problems;
    }

    public Theme(){}
    public String themeName;
    public Problem[] problems;
    public Theme(String themeName, Problem[] problems){
        this.themeName =themeName;
        this.problems = problems;
    }
}
