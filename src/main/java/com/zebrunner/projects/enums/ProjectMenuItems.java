package com.zebrunner.projects.enums;

public enum ProjectMenuItems {
    ALPHA_BUTTON("ALPHA"),
    BETA_BUTTON("BETA"),
    DEFAULT_BUTTON("DEF");

    private final String locator;

    ProjectMenuItems(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
