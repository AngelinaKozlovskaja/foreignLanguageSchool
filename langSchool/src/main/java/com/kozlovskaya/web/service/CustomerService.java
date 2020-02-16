package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Customer;

import java.util.List;

public interface CustomerService {
    void saveOrUpdate(Customer customer);
    void remove(Customer customer);
    List<Customer> findAll();
    Customer findById(Integer id);
    Customer findByLoginAndPass(String login, String password);
    Customer getAdministrator();
}
