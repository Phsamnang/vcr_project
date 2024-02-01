package com.vcr.vcr_project.enums;

public enum SaleStatus {
    PAID("paid"),
    UNPAID("unpaid");

    String value;

    SaleStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
