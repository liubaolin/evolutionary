package com.baolinliu.springDataJpa.service;

import com.baolinliu.springDataJpa.domain.Customer;
import com.baolinliu.springDataJpa.repository.CustomerCrudRepository;
import com.baolinliu.springDataJpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Richey on 2017/6/14.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    @Transactional
    public void update(Long id, Integer age) {
        customerRepository.update(id, age);
    }

    @Transactional
    public void saveCustomers(List<Customer> customerList) {
        customerCrudRepository.save(customerList);
    }

}
