package com.zebrunner.projects.enums;

public enum EnvironmentTypeEnum {

    INTEGER(0, "Integer"),
    BOOLEAN(1, "Boolean"),
    CHOICE(2, "Choice"),
    STRING(3, "String");

    private final int position;
    private final String title;
    EnvironmentTypeEnum(int position, String title){
        this.position = position;
        this.title = title;
    }
    public int getPosition(){
        return position;
    }
    public String getTitle(){
        return title;
    }
}
