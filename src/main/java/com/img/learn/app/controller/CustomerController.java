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

/**
 * Rest endpoint to perform operation of creating, retrieving, updating and deleting Customer
 * resource.
 *
 * @see com.img.learn.app.entity.Customer
 * @see CustomerResponse
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
  private final CustomerService customerService;
  private final CustomerMapper customerMapper;

  /**
   * This endpoint adds a bunch of customer to the database.
   *
   * @param customerNames list of customer names of type {@link String} which needs to be added.
   * @return a success response if all the customer are added success failure otherwise.
   */
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

  /**
   * This endpoint retrieves all the customer from the database.
   *
   * @return the list of all the customer available in the database. empty list is returned in case
   *     of no customer is available.
   */
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

  /**
   * This endpoint retrieves a particular customer from the database.
   *
   * @param customerId the unique identifier of type {@link Integer} customer
   * @return a particular customer with the provided customerId.
   * @throws CustomerServiceException {@link CustomerServiceException} is thrown when no customer is
   *     found with the provided customerId
   */
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

  /**
   * This endpoint updates a customer in the database.
   *
   * @param customerRequest all the information that needs to be updated is provided via this
   *     parameter {@link CustomerRequest}
   * @param customerId the unique identifier of type {@link Integer} customer
   * @return the Customer with the updated details
   * @throws CustomerServiceException {@link CustomerServiceException} is thrown when no customer is
   *     found with the provided customerId
   */
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

  /**
   * This endpoint deletes a customer.
   *
   * @param customerId the unique identifier of type {@link Integer} customer
   * @return successful response if a customer is deleted successfully, failure otherwise
   * @throws CustomerServiceException {@link CustomerServiceException} is thrown when no customer is
   *     found with the provided customerId
   */
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
