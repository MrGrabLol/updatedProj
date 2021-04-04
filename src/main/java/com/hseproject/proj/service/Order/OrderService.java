package com.hseproject.proj.service.Order;

import com.hseproject.proj.model.Order;
import com.hseproject.proj.view.CreateOrderView;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    ResponseEntity<Void> createOrder(CreateOrderView view);

    List<Order> getOrders(Long id);

}
