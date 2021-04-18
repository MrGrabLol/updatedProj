package com.hseproject.proj.view;

import com.hseproject.proj.model.Food;

import java.util.Map;

public class SiteOrderView {

    public Long id;

    public Map<Food, Integer> food;

    public String status;

    public Double price;
}
