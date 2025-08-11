package com.bookshop.bookShop.shared.response;

import org.springframework.http.HttpStatus;

public class ResponseBuilder {
    public static <T> CustomResponse<T> buildSuccessResponse(T data, String message){
        return new CustomResponse<>(true, message, data, HttpStatus.OK.value());
    }

    public static CustomResponse<?> buildErrorResponse(String message, HttpStatus status){
        return new CustomResponse<>(false, message, null, status.value());
    }
}
