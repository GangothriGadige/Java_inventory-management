package com.tw.inventorymanagement;

public class ErrorDTO {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorDTO(String message) {
        this.message = message;
    }

    public ErrorDTO() {
    }
}
