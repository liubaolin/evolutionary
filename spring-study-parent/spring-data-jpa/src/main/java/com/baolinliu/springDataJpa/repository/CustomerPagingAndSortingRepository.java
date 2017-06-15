package com.baolinliu.springDataJpa.repository;

import com.baolinliu.springDataJpa.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Richey on 2017/6/15.
 */
public interface CustomerPagingAndSortingRepository extends PagingAndSortingRepository<Customer,Long> {
}
