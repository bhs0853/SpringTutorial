package com.bhs.examples.springtutorial;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private int status;
    private String error;

    public ErrorResponse(HttpStatus status){
        this.status = status.value();
        this.error = status.getReasonPhrase();
    }
    public void setError(String reasonPhrase) {
        this.error = reasonPhrase;
    }

    public void setStatus(int statusCode) {
        this.status = statusCode;
    }

    public String getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }
    public String toString(){
        return "{" +
                "status : " + status + '\'' +
                "error : " + error + '\'' +
                "}";
    }
}
