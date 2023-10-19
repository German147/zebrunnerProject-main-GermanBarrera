package com.zebrunner.projects.enums.launches;

public enum LaunchesCardOptionsEnum {

    MARK_AS_PASSED(1, "Mark as passed"),
    LINK_ISSUE(2, "Link issue"),
    COPY_URL(3, "Copy URL");

    private final int position;
    private final String title;

    LaunchesCardOptionsEnum(int position, String title) {
        this.position = position;
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }
}
