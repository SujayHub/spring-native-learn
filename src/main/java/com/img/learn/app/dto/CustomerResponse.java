package com.img.learn.app.dto;

import com.img.learn.app.entity.Customer;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Standard object definition of response body for customer resource operations
 * create read or update.
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerResponse extends BaseResponse {

  private Collection<Customer> customers;

}
