package com.hseproject.proj.controller.Order;

import com.hseproject.proj.model.Order;
import com.hseproject.proj.service.Order.OrderService;
import com.hseproject.proj.view.CreateOrderView;
import com.hseproject.proj.view.MyOrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    final
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/my_orders")
    public List<MyOrderView> getMyOrders(@RequestParam("id") Long id) {
        return orderService.getOrders(id);
    }

    @PostMapping("/create_order")
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderView view) {
        return orderService.createOrder(view);
    }
}
