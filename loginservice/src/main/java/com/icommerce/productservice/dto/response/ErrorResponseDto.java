package com.icommerce.productservice.dto.response;

public class ErrorResponseDto extends ResponseDto<String> {
    public ErrorResponseDto(int status, String data) {
        super(status, data);
    }
}
