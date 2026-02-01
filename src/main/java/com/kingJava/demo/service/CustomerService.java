package com.kingJava.demo.service;

import com.kingJava.demo.dto.CustomerDTO;
import com.kingJava.demo.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {


    CustomerDTO getCustomerById(int customerId);

    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getByActiveStatus(boolean status);


}
