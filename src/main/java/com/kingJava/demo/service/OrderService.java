package com.kingJava.demo.service;

import com.kingJava.demo.dto.paginated.PaginatedResponseOrderDetails;
import com.kingJava.demo.dto.request.RequestOrderSaveDTO;
import jakarta.validation.constraints.Max;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, @Max(50) int size);
}
