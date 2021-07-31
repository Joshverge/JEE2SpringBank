package com.jeespb.databaseservice.dto.response;

public class ErrorResponseDto extends ResponseDto<String> {
    public ErrorResponseDto(int status, String data) {
        super(status, data);
    }
}
