package com.zebrunner.projects.enums;

public enum FiltersEnum {
    PASSED(1, "Passed"),
    FAILED(2, "Failed"),
    SKIPPED(3, "Skipped"),
    ABORTED(4, "Aborted"),
    IN_PROGRESS(5, "In Progress"),
    CHROME(6, "chrome"),
    ELECTRON(7, "electron"),
    NA(8, "n/a"),
    ANDROID(9, "android"),
    API(10, "api"),
    LINUX(11, "linux"),
    MACOS(12, "macos"),
    ND(13, "n/d");

    private final int value;
    private final String name;

    FiltersEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
