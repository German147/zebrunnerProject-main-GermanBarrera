package com.zebrunner.projects.pages.launchersPage.enumLauncher;

public enum RepoButtonEnum {

    GITHUB(1,"Github"),
    GITLAB(2,"Gitlab"),
    BITBUCKET(3,"Bitbucket");

    private final int repoPosition;
    private final String repoTitle;

    RepoButtonEnum(int repoPosition, String repoTitle) {
        this.repoPosition = repoPosition;
        this.repoTitle = repoTitle;
    }

    public int getRepoPosition(){
        return repoPosition;
    }
    public String getRepoTitle(){
        return repoTitle;
    }
}
