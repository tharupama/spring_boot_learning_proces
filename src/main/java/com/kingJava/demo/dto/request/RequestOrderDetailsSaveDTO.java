package com.kingJava.demo.dto.request;

import com.kingJava.demo.entity.Item;
import com.kingJava.demo.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RequestOrderDetailsSaveDTO {
    private double amount;
    private String itemName;
    private int items;
    private int orders;
    private double qty;


}
