package com.zebrunner.projects.enums.launches;

public enum LaunchesReportHeaderOptionsEnum {
    EXPORT_TO_HTML(1, "Export to HTML"),
    ASSIGN_TO_MILESTONE(2, "Assign to milestone"),
    DELETE(3, "Delete");

    private final int position;
    private final String title;

    LaunchesReportHeaderOptionsEnum(int position, String title) {
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
