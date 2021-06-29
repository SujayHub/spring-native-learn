package com.img.learn.app.service.impl;

import static com.img.learn.app.data.CustomerServiceError.CUSTOMER_NOT_FOUND;
import static java.util.stream.Collectors.toList;

import com.img.learn.app.entity.Customer;
import com.img.learn.app.exception.CustomerServiceException;
import com.img.learn.app.repo.CustomerRepo;
import com.img.learn.app.service.CustomerService;
import java.util.Collection;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepo customerRepo;

  @Override
  public void addCustomer(final Collection<String> customerNames) {
    customerRepo.saveAll(
        customerNames.stream()
            .map(customerName -> new Customer(null, customerName))
            .collect(toList()));
  }

  @Override
  public Collection<Customer> getAllCustomers() {
    return customerRepo.findAll();
  }

  @Override
  public Customer getCustomer(final Integer customerId) throws CustomerServiceException {
    Customer customer = customerRepo.findById(customerId).orElse(null);

    if (Objects.nonNull(customer)) {
      return customer;
    }

    throw new CustomerServiceException(
        CUSTOMER_NOT_FOUND.getOperationStatus(),
        CUSTOMER_NOT_FOUND.getErrorMessage(),
        CUSTOMER_NOT_FOUND.getErrorCode());
  }

  @Override
  public Customer updateCustomer(final Customer customer, final Integer customerId)
      throws CustomerServiceException {
    Customer customerEntity = customerRepo.findById(customerId).orElse(null);

    if (Objects.nonNull(customerEntity)) {
      customerEntity.setName(customer.getName());
      return customerRepo.save(customerEntity );
    }

    throw new CustomerServiceException(
        CUSTOMER_NOT_FOUND.getOperationStatus(),
        CUSTOMER_NOT_FOUND.getErrorMessage(),
        CUSTOMER_NOT_FOUND.getErrorCode());
  }

  @Override
  public void deleteCustomer(Integer customerId) throws CustomerServiceException {
    if (customerRepo.existsById(customerId)) {
      customerRepo.deleteById(customerId);
      return;
    }

    throw new CustomerServiceException(
        CUSTOMER_NOT_FOUND.getOperationStatus(),
        CUSTOMER_NOT_FOUND.getErrorMessage(),
        CUSTOMER_NOT_FOUND.getErrorCode());
  }
}
