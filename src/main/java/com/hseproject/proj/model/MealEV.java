package com.hseproject.proj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "meal_ev")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealEV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double lipids;

    private Double proteins;

    private Double hydr;

    private Double energy;

    private String about;

    public MealEV(Double lipids, Double proteins, Double hydr, Double energy, String about) {
        this.lipids = lipids;
        this.proteins = proteins;
        this.hydr = hydr;
        this.energy = energy;
        this.about = about;
    }
}
