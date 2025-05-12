package com.example.apiproductservice.exceptions;

import com.example.apiproductservice.dtos.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvice {
    public ErrorResponseDto handleRuntimeException(RuntimeException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setStatus("error");
        errorResponseDto.setMessage(ex.getMessage());
        return errorResponseDto;
    }
    @ExceptionHandler(Exception.class)
    public String handlingException()
    {
        return "unknow error";
    }
}
