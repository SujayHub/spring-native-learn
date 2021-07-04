package com.img.learn.app.exception;

import com.img.learn.app.data.OperationStatus;
import lombok.Getter;

/** Custom exception for CustomerService. */
@Getter
public class CustomerServiceException extends Exception {
  private final OperationStatus operationStatus;
  private final int errorCode;

  /**
   * Parametrised constructor for CustomerServiceException.
   *
   * @param operationStatus - {@link OperationStatus}
   * @param errorMessage - custom error message of type {@link String}
   * @param errorCode - custom error code should be similar to HttpStatus {@link
   *     org.springframework.http.HttpStatus} codes
   */
  public CustomerServiceException(
      final OperationStatus operationStatus, final String errorMessage, int errorCode) {
    super(errorMessage);
    this.operationStatus = operationStatus;
    this.errorCode = errorCode;
  }
}
