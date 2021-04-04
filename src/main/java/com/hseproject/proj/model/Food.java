package com.hseproject.proj.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "meal")
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double price;

    @ManyToMany
    private List<Tag> tag;

    @ManyToOne
    private Category category;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private MealEV mealEV;

    private String image;

    public Food() {}

    public Food(String name, int price, List<Tag> tags, Category category, MealEV mealEV) {
        this.name = name;
        this.price = price;
        this.tag = tags;
        this.category = category;
        this.mealEV = mealEV;
    }

    public Food(String name, int price, List<Tag> tags, Category category) {
        this.name = name;
        this.price = price;
        this.tag = tags;
        this.category = category;
    }

    public Food(String name, double price, List<Tag> tag, Category category, MealEV mealEV, String image) {
        this.name = name;
        this.price = price;
        this.tag = tag;
        this.category = category;
        this.mealEV = mealEV;
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category type) {
        this.category = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Tag> getTags() {
        return tag;
    }

    public void setTags(List<Tag> tags) {
        this.tag = tags;
    }

}
