package com.hseproject.proj.service.FoodType;

import com.hseproject.proj.model.Category;
import com.hseproject.proj.view.TypeAddView;

import java.util.List;

public interface FoodTypeService {

    void add(TypeAddView type);

    void edit(Category type);

    void delete(Category type);

    Category getById(Long id);

    List<Category> getAll();
}
