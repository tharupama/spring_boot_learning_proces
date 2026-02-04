package com.kingJava.demo.dto.request;

import com.kingJava.demo.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data//include getter setter and to string,
public class ItemSaveRequestDTO {

    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;


}
