package com.hseproject.proj.service.Order;

import com.hseproject.proj.view.CreateOrderView;
import com.hseproject.proj.view.MyOrderView;
import com.hseproject.proj.view.SiteOrderView;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    ResponseEntity<Void> createOrder(CreateOrderView view);

    List<MyOrderView> getOrders(Long id);

    List<SiteOrderView> getActiveOrders();

    void setNextStatus(Long id);
}
