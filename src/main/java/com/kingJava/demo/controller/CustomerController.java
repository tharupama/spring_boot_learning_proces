package com.kingJava.demo.controller;

import com.kingJava.demo.dto.CustomerDTO;
import com.kingJava.demo.dto.request.CustomerUpdateDTO;
import com.kingJava.demo.service.CustomerService;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired // property injection
    CustomerService customerService;

    @PostMapping("/save")
    public String customerSave(@RequestBody CustomerDTO customerDTO) {
        //convert json type to java class type

        customerService.saveCustomer(customerDTO);
        return "saved";

    }

    @PutMapping("/update")
    public String customerUpdate(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

    @GetMapping(path="/get-by-id", params = "id")//if we use params name as parameter without customerId we don't need to use @RequestParam
    public CustomerDTO getCustomerById(@RequestParam (value = "id") int customerId) {
        //System.out.println(customerId);
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;//postman get java class object automatically as json object because response body in already included in @RestController, but java will not get automatically json object as java obk we should use request body.

    }

    @GetMapping("/get-all-customers")
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value="id") int customerId) {
    String deleted = customerService.deleteCustomer(customerId);
    return deleted;
    }

    @GetMapping("/get-by-active-status/{status}")
    public List<CustomerDTO> getByActiveStatus(boolean status) {
        List<CustomerDTO> correspondingCustomers = customerService.getByActiveStatus(status);
           return correspondingCustomers;
    }

    }//class close tag
