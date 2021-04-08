package com.hseproject.proj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Date;
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
    @JoinColumn(nullable = false)
    private User customerId;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Order(Map<Food, Integer> food, OrderStatus status, double price, User customerId) {
        this.food = food;
        this.status = status;
        this.price = price;
        this.customerId = customerId;
        date = Calendar.getInstance().getTime();
    }
}
