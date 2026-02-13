package com.kingJava.demo.controller;

import com.kingJava.demo.dto.paginated.PaginatedResponseOrderDetails;
import com.kingJava.demo.dto.request.ItemSaveRequestDTO;
import com.kingJava.demo.dto.request.RequestOrderSaveDTO;
import com.kingJava.demo.service.ItemService;
import com.kingJava.demo.service.OrderService;
import com.kingJava.demo.util.StanderdResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/save")
    public ResponseEntity<StanderdResponse> itemSave(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        String sucess = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StanderdResponse>(new StanderdResponse(201,"sucess",sucess), HttpStatus.CREATED);
    }

    @GetMapping(params = {"activeStatus","page","size"}, path = "/get-order-details")
    public ResponseEntity<StanderdResponse>getOrderDetails(
            @RequestParam(value="activeStatus") String activeStatus,
            @RequestParam(value="page") int page,
            @RequestParam(value="size") @Max(50) int size

            ){
        PaginatedResponseOrderDetails p =  null;
        if(activeStatus.equalsIgnoreCase("active")||activeStatus.equalsIgnoreCase("inactive")){
            boolean status = (activeStatus.equalsIgnoreCase("active")?true:false);
            p = orderService.getAllOrderDetails(status,page,size);

        }
        return new ResponseEntity<StanderdResponse>(new StanderdResponse(200,"success",p),HttpStatus.OK);
    }
}

