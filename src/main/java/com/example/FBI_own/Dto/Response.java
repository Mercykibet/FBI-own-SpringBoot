package com.example.FBI_own.Dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonSerialize
public class Response<T> {
    T data;
    String message;
    int status;

    public Response(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Response() {

    }
//
//    public Response() {
//    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
