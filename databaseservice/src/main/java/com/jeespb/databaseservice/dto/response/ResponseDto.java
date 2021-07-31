package com.jeespb.databaseservice.dto.response;

public class ResponseDto<T> {

    protected static final int SUCCESS_CODE = 200;

    private int status;
    private T data;

    public ResponseDto(T data) {
        this.status = SUCCESS_CODE;
        this.data = data;
    }

    public ResponseDto(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
