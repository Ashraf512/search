package com.mobile.search.dto;

import com.mobile.search.entity.Customer;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {

    private Integer id;
    private String name;
    private String phone;

    public CustomerDto convertEntityToDto (Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.phone = customer.getPhone();
        return this;
    }

    public Customer convertDtoToEntity (){
        var customer = new Customer();
        customer.setId(this.id);
        customer.setName(this.name);;
        customer.setPhone(this.phone); ;
        return customer;
    }



}
