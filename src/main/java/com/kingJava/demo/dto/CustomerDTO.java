package com.kingJava.demo.dto;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private List<String> customerContact = new ArrayList<>(); //to use arraylist we need json.
    private String nic;
    private boolean active;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String customerAddress, double customerSalary, List<String> customerContact, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.customerContact = customerContact;
        this.nic = nic;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public List<String> getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(List<String> customerContact) {
        this.customerContact = customerContact;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", customerContact=" + customerContact +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
