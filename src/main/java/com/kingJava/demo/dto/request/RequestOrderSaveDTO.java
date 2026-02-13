package com.kingJava.demo.dto.request;

import com.kingJava.demo.entity.Customer;
import com.kingJava.demo.entity.Order;
import com.kingJava.demo.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customer;
    private Date date;
    private List<RequestOrderDetailsSaveDTO> orderDetails;
    private Double total;

}
