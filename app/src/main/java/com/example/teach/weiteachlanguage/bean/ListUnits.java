package com.example.teach.weiteachlanguage.bean;

/**
 * Created by gaonqiang on 2018/1/12.
 */

public class ListUnits {

    private String unitName;
    private Boolean exerciseState;
    private String theme;

    public ListUnits(String unitName,String theme,Boolean exerciseState) {
        this.unitName=unitName;
        this.theme=theme;
        this.exerciseState=exerciseState;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Boolean getExerciseState() {
        return exerciseState;
    }

    public void setExerciseState(Boolean exerciseState) {
        this.exerciseState = exerciseState;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}
