package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Customer;
import com.kozlovskaya.web.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void remove(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer findByLoginAndPass(String login, String password) {
        return customerRepository.findCustomerByLoginAndPass(login, password);
    }

    @Override
    public Customer getAdministrator() {
        return customerRepository.findCustomerByUserRole("admin");
    }
}
