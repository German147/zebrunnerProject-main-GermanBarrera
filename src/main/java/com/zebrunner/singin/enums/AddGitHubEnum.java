package com.zebrunner.singin.enums;

public enum AddGitHubEnum {

    USERNAME_GIT("username"),
    URL_GIT("url"),
    TOKEN_GIT_HUB("token");
    private final String id;
    AddGitHubEnum(String id){
        this.id=id;
    }

    public String getGitCredentials(){
        return this.id;
    }
}
