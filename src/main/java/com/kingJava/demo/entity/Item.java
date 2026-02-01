package com.kingJava.demo.entity;

import com.kingJava.demo.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Item")
@NoArgsConstructor
public class Item {
    @Id
    @Column(name="item_id", length=50)
    @GeneratedValue
    private int itemId;

    @Column(name="item_name", length=50, nullable=false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="measure_type", nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name="balance_qty", nullable = false)
    private double balanceQty;

    @Column(name="supplier_price", nullable = false)
    private double supplierPrice;

    @Column(name="selling_price",nullable = false)
    private double sellingPrice;

    @Column(name="active_state", columnDefinition = "TINYINT default 0")
    private boolean active;


}
