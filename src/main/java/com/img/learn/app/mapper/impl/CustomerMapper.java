package com.img.learn.app.mapper.impl;

import com.img.learn.app.dto.CustomerRequest;
import com.img.learn.app.entity.Customer;
import com.img.learn.app.mapper.DtoEntityMapper;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 * converter layer for {@link CustomerRequest} dto and {@link Customer} entity.
 */
@Component
public class CustomerMapper implements DtoEntityMapper<CustomerRequest, Customer> {

  @Override
  public Customer toEntity(CustomerRequest customerRequest) {
    if (Objects.nonNull(customerRequest)) {
      Customer customer = new Customer();
      customer.setName(customerRequest.getName());
      return customer;
    }
    return null;
  }

  @Override
  public CustomerRequest toDto(Customer customer) {
    if (Objects.nonNull(customer)) {
      return CustomerRequest.builder().name(customer.getName()).build();
    }
    return null;
  }
}
