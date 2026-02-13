package com.kingJava.demo.dto.response;

import com.kingJava.demo.dto.request.RequestOrderDetailsSaveDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDTO {
    //customer
    private String customerName;
    private String customerAddress;
    private List<String> customerContact = new ArrayList<>();

    //order
    private Date date;
    private Double total;
}
