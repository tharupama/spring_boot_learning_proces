package com.kingJava.demo.dto.response;

import com.kingJava.demo.entity.enums.MeasuringUnitType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean active;
}
