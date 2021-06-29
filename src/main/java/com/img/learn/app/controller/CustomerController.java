package com.img.learn.app.controller;

import static com.img.learn.app.data.OperationStatus.SUCCESS;
import static org.springframework.http.HttpStatus.CREATED;

import com.img.learn.app.dto.BaseResponse;
import com.img.learn.app.dto.CustomerRequest;
import com.img.learn.app.dto.CustomerResponse;
import com.img.learn.app.exception.CustomerServiceException;
import com.img.learn.app.mapper.impl.CustomerMapper;
import com.img.learn.app.service.CustomerService;
import java.util.Collection;
import java.util.Collections;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
  private final CustomerService customerService;
  private final CustomerMapper customerMapper;

  @PostMapping
  public ResponseEntity<BaseResponse> addCustomers(
      @RequestBody @NotNull final Collection<String> customerNames) {
    customerService.addCustomer(customerNames);
    return ResponseEntity.status(CREATED)
        .body(
            BaseResponse.builder()
                .responseCode(SUCCESS.getCode())
                .operationStatus(SUCCESS)
                .responseMessage(SUCCESS.name())
                .build());
  }

  @GetMapping
  public ResponseEntity<BaseResponse> getAllCustomers() {
    return ResponseEntity.ok(
        CustomerResponse.builder()
            .customers(customerService.getAllCustomers())
            .responseCode(SUCCESS.getCode())
            .operationStatus(SUCCESS)
            .responseMessage(SUCCESS.name())
            .build());
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<BaseResponse> getAllCustomers(
      @PathVariable @NotNull final Integer customerId) throws CustomerServiceException {
    return ResponseEntity.ok(
        CustomerResponse.builder()
            .customers(Collections.singleton(customerService.getCustomer(customerId)))
            .responseCode(SUCCESS.getCode())
            .operationStatus(SUCCESS)
            .responseMessage(SUCCESS.name())
            .build());
  }

  @PutMapping("/{customerId}")
  public ResponseEntity<BaseResponse> updateCustomer(
      @RequestBody @NotNull final CustomerRequest customerRequest,
      @PathVariable @NotNull final Integer customerId)
      throws CustomerServiceException {
    return ResponseEntity.ok(
        CustomerResponse.builder()
            .customers(
                Collections.singleton(
                    customerService.updateCustomer(
                        customerMapper.toEntity(customerRequest), customerId)))
            .responseCode(SUCCESS.getCode())
            .operationStatus(SUCCESS)
            .responseMessage(SUCCESS.name())
            .build());
  }

  @DeleteMapping("/{customerId}")
  public ResponseEntity<BaseResponse> deleteCustomer(
      @PathVariable @NotNull final Integer customerId) throws CustomerServiceException {
    customerService.deleteCustomer(customerId);
    return ResponseEntity.ok(
        BaseResponse.builder()
            .responseCode(SUCCESS.getCode())
            .operationStatus(SUCCESS)
            .responseMessage(SUCCESS.name())
            .build());
  }
}
