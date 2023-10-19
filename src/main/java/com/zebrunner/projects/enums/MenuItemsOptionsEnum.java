package com.zebrunner.projects.enums;

import static com.zebrunner.projects.enums.MenuItemsEnum.*;

public enum MenuItemsOptionsEnum {
    TEST_CASES(TEST_REPOSITORY, "Test cases", "test-cases"),
    SHARED_STEPS(TEST_REPOSITORY, "Shared steps", "shared-steps"),
    LAUNCHES(AUTOMATION, "Launches", "automation-launches?page=1"),
    LAUNCHERS(AUTOMATION, "Launchers", "automation-launchers"),
    DASHBOARDS(AUTOMATION, "Dashboards", "automation-dashboards"),
    GENERAL(SETTINGS, "General", "settings"),
    TESTING_CONFIGURATIONS(SETTINGS, "Testing configurations", "testing-configurations"),
    ENVIRONMENTS_AND_VARIABLES(SETTINGS, "Environments and variables", "environments-variables");

    private final MenuItemsEnum parent;
    private final String name;
    private final String urlPart;
    MenuItemsOptionsEnum(MenuItemsEnum parent, String name, String urlPart){
        this.parent = parent;
        this.name = name;
        this.urlPart = urlPart;
    }

    public MenuItemsEnum getMenuItemParent(){
        return parent;
    }
    public String getOptionName(){
        return name;
    }
    public String getUrlPart(){
        return urlPart;
    }
}
