package com.bookshop.bookShop.shared.response;

public class CustomResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private int statusCode;

    public CustomResponse(){}
    public CustomResponse(boolean success, String message, T data, int statusCode) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    public boolean isSuccess(){
        return success;
    }

    public String getMessage(){
        return message;
    }

    public T getData(){
        return data;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
