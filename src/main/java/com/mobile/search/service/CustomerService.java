package com.mobile.search.service;

import com.mobile.search.dto.CustomerDto;
import com.mobile.search.entity.Customer;
import com.mobile.search.enums.Country;
import com.mobile.search.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<Object> findALl(Country country) {
        if (country != null)
            return new ResponseEntity<>(findByCountry(country), HttpStatus.OK);
        else {
            List<Customer> customers = customerRepository.findAll();
            List<CustomerDto> customerDtos = new ArrayList<>();
            customers.forEach(customer -> customerDtos.add(new CustomerDto().convertEntityToDto(customer)));
            return new ResponseEntity<>(customerDtos, HttpStatus.OK);
        }
    }

    private boolean matches(String regex, String mobileNumber) {
        return Pattern.matches(regex, mobileNumber);
    }

    public List<CustomerDto> findByCountry(Country country) {
        List<Customer> customers = customerRepository.findAllByPhoneStartingWith(country.getCode());
        List<CustomerDto> customerDtos = new ArrayList<>();
        customers.forEach(customer -> {
            if (customer.getPhone() != null && matches(country.getRegEx(), customer.getPhone()))
                customerDtos.add(new CustomerDto().convertEntityToDto(customer));
        });

        return customerDtos;
    }

}
