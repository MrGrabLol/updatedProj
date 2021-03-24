package com.hseproject.proj.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private int price;

    private String composition;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Tag> tags;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private FoodType type;

    public Food() {}

    public Food(String name, int price, String composition, List<Tag> tags, FoodType type) {
        this.name = name;
        this.price = price;
        this.composition = composition;
        this.tags = tags;
        this.type = type;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", composition='" + composition + '\'' +
                '}';
    }
}
