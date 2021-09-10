package com.mobile.search.controller;

import com.mobile.search.enums.Country;
import com.mobile.search.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customers")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> findAll(@RequestParam(name = "country", required = false) Country country) {
        return customerService.findALl(country);
    }


}
