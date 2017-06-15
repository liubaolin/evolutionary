package com.baolinliu.springDataJpa.repository;

import com.baolinliu.springDataJpa.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Richey on 2017/6/15.
 */
public interface CustomerSpecificationExecutorRepository extends JpaSpecificationExecutor<Customer> ,JpaRepository<Customer,Long>{
}
