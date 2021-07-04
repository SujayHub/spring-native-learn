package com.img.learn.app.repo;

import com.img.learn.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface to persist data in Customer table in database.
 *
 * @see JpaRepository
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {}
