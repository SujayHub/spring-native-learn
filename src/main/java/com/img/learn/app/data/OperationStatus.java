package com.img.learn.app.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperationStatus {
  FAILURE(-1),
  SUCCESS(0),
  PENDING(1);

  private final int code;
}
