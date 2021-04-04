package com.hseproject.proj.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "meal_ev")
@Data
public class MealEV {

    @Id
    private Long id;

    private Double lipids;

    private Double proteins;

    private Double hydr;

    private Double energy;

    private String about;
}
