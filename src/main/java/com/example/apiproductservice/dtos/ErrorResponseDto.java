package com.example.apiproductservice.dtos;

public class ErrorResponseDto {
    private String status;
    private String message;

    public void setMessage(String message) {
            this.message = message;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }

}
