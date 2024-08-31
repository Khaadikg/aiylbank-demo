package com.aiylbank.demo.model.task.entity;

public enum Status {

    OPEN("Открыт"),
    DONE("Сделан");

    public final String description;

    Status(String description) {
        this.description = description;
    }

}
