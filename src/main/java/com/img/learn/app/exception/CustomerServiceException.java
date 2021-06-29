package com.img.learn.app.exception;

import com.img.learn.app.data.OperationStatus;
import lombok.Getter;

@Getter
public class CustomerServiceException extends Exception {
  private final OperationStatus operationStatus;
  private final int errorCode;

  public CustomerServiceException(
      final OperationStatus operationStatus, final String errorMessage, int errorCode) {
    super(errorMessage);
    this.operationStatus = operationStatus;
    this.errorCode = errorCode;
  }
}
