package com.img.learn.app.exception.handler;

import com.img.learn.app.dto.BaseResponse;
import com.img.learn.app.dto.BaseResponse.ErrorResponse;
import com.img.learn.app.exception.CustomerServiceException;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handlers are defined here
 * for all service level exceptions.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  private static final String CUSTOMER_SERVICE_EXCEPTION_RESPONSE_MESSAGE =
      "CUSTOMER_SERVICE_EXCEPTION_HAS_OCCURRED";

  @ExceptionHandler(value = {CustomerServiceException.class})
  protected ResponseEntity<BaseResponse> handleConflict(
      CustomerServiceException ex, WebRequest request) {

    BaseResponse baseResponse =
        BaseResponse.builder()
            .operationStatus(ex.getOperationStatus())
            .responseCode(ex.getOperationStatus().getCode())
            .responseMessage(CUSTOMER_SERVICE_EXCEPTION_RESPONSE_MESSAGE)
            .errors(
                Collections.singleton(
                    ErrorResponse.builder()
                        .errorCode(ex.getErrorCode())
                        .errorReason(ex.getMessage())
                        .build()))
            .build();
    return ResponseEntity.status(HttpStatus.valueOf(ex.getErrorCode())).body(baseResponse);
  }
}
