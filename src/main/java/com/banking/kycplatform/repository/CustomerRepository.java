package com.banking.kycplatform.repository;

import com.banking.kycplatform.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByStatus(String status);
    List<Customer> findByCountry(String country);
}
