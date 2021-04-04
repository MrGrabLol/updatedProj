package com.hseproject.proj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import java.util.List;
import java.util.Map;

@Entity(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @MapKeyColumn(name = "food")
    @Column(name = "amount")
    private Map<Food, Integer> food;

    private OrderStatus status;

    private double price;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false)
    private User customerId;

    public Order(Map<Food, Integer> food, OrderStatus status, double price, User customerId) {
        this.food = food;
        this.status = status;
        this.price = price;
        this.customerId = customerId;
    }
}
