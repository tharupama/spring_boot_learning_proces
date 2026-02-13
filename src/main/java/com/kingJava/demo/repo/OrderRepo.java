package com.kingJava.demo.repo;

import com.kingJava.demo.dto.queryInterfaces.OrderDetailInterface;
import com.kingJava.demo.dto.response.ResponseOrderDetailsDTO;
import com.kingJava.demo.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query(value="SELECT c.customer_name,c.customer_address,c.customer_contact,o.order_date,o.total from customer c,orders o WHERE o.active_state=?1 AND c.customer_id = o.customer_id",nativeQuery = true)
    List<OrderDetailInterface> getAllOrderDetails(boolean status, Pageable pageable);

    @Query(value="SELECT count(*) FROM customer c,orders o WHERE o.active_state=?1 AND c.customer_id = o.customer_id", nativeQuery = true)
    long countAllOrderDetails(boolean status);
}
