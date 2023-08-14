package com.garamgaebee.imageapplication.exception.handler;

import com.garamgaebee.common.exception.BaseException;
import com.garamgaebee.common.exception.ErrorDTO;
import com.garamgaebee.common.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ImageGlobalExceptionHandler extends GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @Override
    public ErrorDTO handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                .code(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .message("Unexpected error!")
                .build();
    }

    @ExceptionHandler(BaseException.class)
    @Override
    public ErrorDTO handleException(BaseException exception) {
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                .code(exception.getBaseErrorCode().getCode())
                .message(exception.getBaseErrorCode().getMessage())
                .build();
    }
}