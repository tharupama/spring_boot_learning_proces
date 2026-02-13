package com.kingJava.demo.service.impl;

import com.kingJava.demo.dto.paginated.PaginatedResponseOrderDetails;
import com.kingJava.demo.dto.queryInterfaces.OrderDetailInterface;
import com.kingJava.demo.dto.request.RequestOrderSaveDTO;
import com.kingJava.demo.dto.response.ResponseOrderDetailsDTO;
import com.kingJava.demo.entity.Order;
import com.kingJava.demo.entity.OrderDetails;
import com.kingJava.demo.repo.CustomerRepo;
import com.kingJava.demo.repo.ItemRepo;
import com.kingJava.demo.repo.OrderDetailRepo;
import com.kingJava.demo.repo.OrderRepo;
import com.kingJava.demo.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(customerRepo.getReferenceById(requestOrderSaveDTO.getCustomer()) , requestOrderSaveDTO.getDate(), requestOrderSaveDTO.getTotal());
        orderRepo.save(order);

        if(orderRepo.existsById(order.getId())){
            List<OrderDetails>orderDetails=new ArrayList<>(
                    modelMapper.map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>(){}.getType())
            );
            for(int i=0;i<orderDetails.size();i++){
                orderDetails.get(i).setOrders(order);
               // orderDetails.get(i).setOrders(orderRepo.getReferenceById(order.getId()));
                orderDetails.get(i).setItems(itemRepo.getReferenceById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if(orderDetails.size()>0){
                orderDetailRepo.saveAll(orderDetails);
            }
            return "order saved successfully";
        }
        return null;
    }

    @Override
    public PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size) {
        List<OrderDetailInterface> orderDetailsDTOS = orderRepo.getAllOrderDetails(status, PageRequest.of(page,size));
        List<ResponseOrderDetailsDTO> list = new ArrayList<>();
        for(OrderDetailInterface o:orderDetailsDTOS){
            ResponseOrderDetailsDTO r = new ResponseOrderDetailsDTO(
            o.getCustomerName(),
            o.getCustomerAddress(),
            o.getCustomerContact(),
            o.getDate(),
            o.getTotal()
            );
            list.add(r);
        }
        PaginatedResponseOrderDetails p = new PaginatedResponseOrderDetails(list,orderRepo.countAllOrderDetails(status));
        return p;
    }

}
