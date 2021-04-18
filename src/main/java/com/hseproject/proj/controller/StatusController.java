package com.hseproject.proj.controller;

import com.hseproject.proj.service.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StatusController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    private String getOrders(Model model) {
        model.addAttribute("orders", orderService.getActiveOrders());
        return "orderSite";
    }

    @GetMapping("/orders/setNextStatus/{id}")
    private String setNextStatus(@PathVariable("id") Long id) {
        orderService.setNextStatus(id);
        return "redirect:/orders";
    }
}
