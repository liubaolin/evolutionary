package com.baolinliu.springDataJpa.repository;

import com.baolinliu.springDataJpa.domain.Customer;
import com.baolinliu.springDataJpa.domain.CustomerVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Richey on 2017/6/14.
 */
@RepositoryDefinition(domainClass = Customer.class, idClass = Long.class)
public interface CustomerRepository { //extends Repository<Customer,Long>{

    public Customer findByName(String name);

    public List<Customer> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    public List<Customer> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    public List<Customer> findByNameInOrAgeLessThan(List<String> names, Integer age);

    @Query("select c from Customer  c where id = (select max(id) from Customer)")
    public Customer getCustomerByMaxId();

    @Query("select c from Customer  c where c.name = ?1 and c.age = ?2")
    public List<Customer> queryParams1(String name, String age);

    @Query("select c from Customer  c where c.name = :name and c.age = :age")
    public List<Customer> queryParams2(@Param("name") String name,@Param("age") String age);

    @Query("select c from Customer c where c.name like %?1%")
    public List<Customer> queryList1(String name);

    @Query("select c from Customer c where c.name like %:name%")
    public List<Customer> queryList2(@Param("name") String name);

    @Query(nativeQuery = true, value = "select count(1) from customer")
    public long getCount();

    @Query(nativeQuery = true, value = "select id,name,age from customer")
    public List<Customer> getNativeCustomer();

    @Query(nativeQuery = true, value = "select id,name,age from customer")
    public List<Object[]> getNativeCustomer2();


    @Modifying
    @Query("update Customer c set c.age = :age where c.id = :id")
    public void update(@Param("id") Long id,@Param("age") Integer age);




}
