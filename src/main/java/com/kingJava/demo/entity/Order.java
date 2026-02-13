package com.kingJava.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)//anith waguwe join wena column eka foreign
    private Customer customer;//mapped by kiyala dana eka

    @Column(name="active_state")
    private boolean active;

    @Column(name="order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "total", nullable = false)
    private Double total;

    public Order(Customer customer, Date orderDate, Double total) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.total = total;
    }

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> ordersDetails;
}
