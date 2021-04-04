package com.hseproject.proj.service.Order;

import com.hseproject.proj.model.Food;
import com.hseproject.proj.model.Order;
import com.hseproject.proj.model.OrderStatus;
import com.hseproject.proj.model.User;
import com.hseproject.proj.view.CreateOrderView;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    final
    EntityManager em;

    public OrderServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public ResponseEntity<Void> createOrder(CreateOrderView view) {
        User user = em.find(User.class, view.clientId);
        Map<Food, Integer> food = view.food;
        double sum = food.keySet().stream().mapToDouble(f -> f.getPrice() * food.get(f)).sum();
        Order order = new Order(food, OrderStatus.CREATED, Precision.round(sum,2), user);
        em.persist(order);
        user.setBonus(user.getBonus() + sum * 0.07);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<Order> getOrders(Long id) {
        TypedQuery<User> userQuery = em.createQuery("SELECT u From users u where u.id = :id", User.class);
        userQuery.setParameter("id", id);
        try {
            userQuery.getSingleResult();
        } catch (Exception e) {
            return Collections.emptyList();
        }
        TypedQuery<Order> orderQuery = em.createQuery("SELECT o FROM orders o WHERE o.customerId = :user", Order.class);
        orderQuery.setParameter("user", userQuery.getResultList());
        try {
            return orderQuery.getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
