package com.hseproject.proj.service.FoodType;

import com.hseproject.proj.model.FoodType;
import com.hseproject.proj.view.TypeAddView;

import java.util.List;

public interface FoodTypeService {

    void add(TypeAddView type);

    void edit(FoodType type);

    void delete(FoodType type);

    FoodType getById(Long id);

    List<FoodType> getAll();
}
