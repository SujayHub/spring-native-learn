package com.img.learn.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.img.learn.app.data.OperationStatus;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Standard response object definition.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class BaseResponse {

  private int responseCode;
  private OperationStatus operationStatus;
  private String responseMessage;
  private Collection<ErrorResponse> errors;


  /**
   * Standard error response object definition.
   */
  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class ErrorResponse {
    private int errorCode;
    private String errorReason;
  }

}
