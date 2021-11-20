package com.img.learn.app.exception;

import static java.util.Objects.requireNonNull;

import com.img.learn.app.data.CustomerServiceError;
import com.img.learn.app.data.OperationStatus;
import lombok.AccessLevel;
import lombok.Getter;

/** Custom exception for CustomerService. */
@Getter
public class CustomerServiceException extends Exception {
  @Getter(AccessLevel.NONE)
  private static final String ERROR_MESSAGE_NOT_DEFINED = "error message not defined";
  private final OperationStatus operationStatus;
  private final int errorCode;

  /**
   * Parametrised constructor for CustomerServiceException.
   * @param customerServiceError - {@link CustomerServiceError}
   */
  public CustomerServiceException(CustomerServiceError customerServiceError) {
    super(requireNonNull(customerServiceError.getErrorMessage(), ERROR_MESSAGE_NOT_DEFINED));
    this.operationStatus = customerServiceError.getOperationStatus();
    this.errorCode = customerServiceError.getErrorCode();
  }
}
