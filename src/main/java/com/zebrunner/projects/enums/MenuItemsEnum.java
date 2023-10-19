package com.zebrunner.projects.enums;

public enum MenuItemsEnum {
    TEST_REPOSITORY(1, "Test Repository"),
    TEST_RUNS(2, "Test runs"),
    AUTOMATION(3, "Automation"),
    SETTINGS(4, "Settings");

    private final int position;
    private final String title;
    MenuItemsEnum(int position, String title){
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
