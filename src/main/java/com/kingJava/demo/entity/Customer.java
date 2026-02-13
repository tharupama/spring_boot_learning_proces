package com.kingJava.demo.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")//defalt take class name as a table name, if you want to change it use @Table annotation

public class Customer {

    @Id //specify primary key

    @Column(name = "customer_id", length = 45)//defalt take field name as a column name, if you want to change it use @Column annotation
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name="customer_name", length=100, nullable = false)
    private String customerName;

    @Column(name="customer_address", length=255)
    private String customerAddress;

    @Column(name="customer_salary")
    private double customerSalary;

    @Type(JsonType.class) // ✅ CORRECT: From hibernate-types-6 (NOT hibernate-types-52)
    @Column(name = "customer_contact", columnDefinition = "jsonb")
    private List<String> customerContact = new ArrayList<>(); //to use arraylist we need json.

    @Column(name="nic", length=12, unique = true)//cant be duplicate
    private String nic;

    @Column(name="active_state", columnDefinition = "TINYINT default 0")
    private boolean active;

    @OneToMany(mappedBy="customer")
    private Set<Order> orders;//column hadenne na



    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, List<String> customerContact, String nic, boolean active) {
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
        return "Customer{" +
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
