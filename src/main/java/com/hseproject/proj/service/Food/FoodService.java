package com.hseproject.proj.service.Food;

import com.hseproject.proj.model.Food;
import com.hseproject.proj.model.FoodType;
import com.hseproject.proj.view.FoodAddView;

import java.util.List;

public interface FoodService {

    void add(FoodAddView food);

    void edit(Food food);

    void delete(Food food);

    Food getById(Long id);

    List<Food> getAll();
}

