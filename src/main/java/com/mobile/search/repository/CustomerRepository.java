package com.mobile.search.repository;

import com.mobile.search.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByPhoneStartingWith(String countryCode);

}
