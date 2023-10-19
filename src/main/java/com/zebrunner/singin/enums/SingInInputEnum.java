package com.zebrunner.singin.enums;

public enum SingInInputEnum {
    USER("accessKey"),
    PASSWORD("password");

    private final String id;
    SingInInputEnum(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}
