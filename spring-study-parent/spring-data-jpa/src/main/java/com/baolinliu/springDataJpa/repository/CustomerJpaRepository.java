package com.baolinliu.springDataJpa.repository;

import com.baolinliu.springDataJpa.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Richey on 2017/6/15.
 */
public interface CustomerJpaRepository  extends JpaRepository<Customer,Long>{
}
