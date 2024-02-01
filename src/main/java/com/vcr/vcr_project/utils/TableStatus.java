package com.vcr.vcr_project.utils;

public enum TableStatus {
    AVAILABLE("available"),
    UNAVAILABLE("unavailable"),
    PENDING("pending");

    private final String value;

    TableStatus(String value) {
        this.value = value;
    }
}
