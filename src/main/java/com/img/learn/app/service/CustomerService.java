package com.img.learn.app.service;

import com.img.learn.app.entity.Customer;
import com.img.learn.app.exception.CustomerServiceException;
import java.util.Collection;
import javax.validation.constraints.NotNull;

public interface CustomerService {

  void addCustomer(@NotNull Collection<String> customerNames);
  Collection<Customer> getAllCustomers();
  Customer getCustomer(@NotNull final Integer customerId) throws CustomerServiceException;
  Customer updateCustomer(@NotNull final Customer customer, @NotNull final Integer customerId )
      throws CustomerServiceException;
  void deleteCustomer(@NotNull final Integer customerId) throws CustomerServiceException;
}
