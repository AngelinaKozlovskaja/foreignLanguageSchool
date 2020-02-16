package com.kozlovskaya.web.repository;

import com.kozlovskaya.web.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerByLoginAndPass(String login, String pass);
    Customer findCustomerByLogin(String login);
    Customer findCustomerByUserRole(String userRole);
}
