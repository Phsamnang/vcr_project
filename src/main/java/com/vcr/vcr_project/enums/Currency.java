package com.vcr.vcr_project.enums;

public enum Currency {
    RIEL("riel"),
    USD("usd");

    String value;

    Currency(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
