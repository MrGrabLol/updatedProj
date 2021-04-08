package com.hseproject.proj.service.Order;

import com.hseproject.proj.model.AuthModel;
import com.hseproject.proj.model.Food;
import com.hseproject.proj.model.Order;
import com.hseproject.proj.model.OrderStatus;
import com.hseproject.proj.model.User;
import com.hseproject.proj.view.CreateOrderView;
import com.hseproject.proj.view.MyOrderView;
import lombok.val;
import org.apache.commons.math3.util.Precision;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    final EntityManager em;

    public OrderServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public ResponseEntity<Void> createOrder(CreateOrderView view) {
        TypedQuery<AuthModel> model = em.createQuery("SELECT m FROM auth_model m WHERE m.login like :login",
                AuthModel.class);
        model.setParameter("login", view.login);
        TypedQuery<User> userQuery = em.createQuery("SELECT u FROM users u WHERE u.authModel = :model", User.class);
        userQuery.setParameter("model", model.getSingleResult());
        User user = userQuery.getSingleResult();
        List<Food> food = view.food;
        List<Integer> amount = view.amount;
        Map<Food, Integer> map = new HashMap<>();
        food.forEach(f -> map.put(f, amount.get(food.indexOf(f))));
        double sum = food.stream().mapToDouble(f -> f.getPrice() * amount.get(food.indexOf(f))).sum();
        Order order = new Order(map, OrderStatus.CREATED, Precision.round(sum,2), user);
        em.persist(order);
        user.setBonus(user.getBonus() + sum * 0.07);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<MyOrderView> getOrders(Long id) {
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
            List<Order> orders = orderQuery.getResultList();
            List<MyOrderView> myOrderViews = new ArrayList<>();
            for (Order o: orders) {
                MyOrderView order = new MyOrderView();
                List<Food> foods = new ArrayList<>();
                List<Integer> amount = new ArrayList<>();
                val map = o.getFood();
                map.keySet().forEach(f -> {
                    foods.add(f);
                    amount.add(map.get(f));
                });
                order.food = foods;
                order.amount = amount;
                order.price = o.getPrice();
                order.status = o.getStatus();
                myOrderViews.add(order);
            }
            return myOrderViews;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
