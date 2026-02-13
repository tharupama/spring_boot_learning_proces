package com.kingJava.demo.dto.queryInterfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface OrderDetailInterface {

    String getCustomerName();//type methods
    String getCustomerAddress();
    List<String> getCustomerContact();
    Date getDate();
    Double getTotal();

}
