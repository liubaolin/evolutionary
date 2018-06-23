package com.baolinliu.springDataJpa.repository;

import com.baolinliu.springDataJpa.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Richey on 2017/6/15.
 */
public interface CustomerCrudRepository extends CrudRepository<Customer,Long> {
}
