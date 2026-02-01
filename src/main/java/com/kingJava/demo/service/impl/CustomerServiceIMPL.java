package com.kingJava.demo.service.impl;

import com.kingJava.demo.dto.CustomerDTO;
import com.kingJava.demo.dto.request.CustomerUpdateDTO;
import com.kingJava.demo.entity.Customer;
import com.kingJava.demo.repo.CustomerRepo;
import com.kingJava.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // include @component
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getCustomerContact(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;

        }else{
            throw new RuntimeException("no customer");
        }
    }

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
              customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getCustomerContact(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
       //convert dto(java clas type data) data to customer entity.
        customerRepo.save(customer);

        System.out.println(customerDTO.getCustomerAddress());
        return "";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())) {

            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName()+" updated sucessfully.";

        }else{
            throw new RuntimeException("Customer not found");

        }


    }


    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getCustomerContact(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Customer deleted sucessfully.";
        }else{
            return "Customer not found";
        }
    }

    @Override
    public List<CustomerDTO> getByActiveStatus(boolean status) {
        List<Customer> customers = customerRepo.findAllByActiveEquals(status);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getCustomerContact(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
