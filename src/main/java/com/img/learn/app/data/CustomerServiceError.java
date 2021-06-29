package com.img.learn.app.data;

import static com.img.learn.app.data.OperationStatus.FAILURE;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomerServiceError {
  CUSTOMER_NOT_FOUND(FAILURE,404, "CUSTOMER_NOT_FOUND");

  private final OperationStatus operationStatus;
  private final int errorCode;
  private final String errorMessage;
}
