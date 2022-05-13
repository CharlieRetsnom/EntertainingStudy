package ru.efimovpavel.entertainigstudy.Models;

import java.io.Serializable;

public class Chapter implements Serializable {
    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Theme[] getThemes() {
        return themes;
    }

    public void setThemes(Theme[] themes) {
        this.themes = themes;
    }

    public Chapter(){}
    public String chapterName;
    public Theme[] themes;
    public Chapter(String chapterName, Theme[] themes){
        this.chapterName=chapterName;
        this.themes=themes;
    }
}
