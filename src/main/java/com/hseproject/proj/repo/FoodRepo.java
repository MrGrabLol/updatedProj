package com.hseproject.proj.repo;

import com.hseproject.proj.model.Food;
import com.hseproject.proj.model.FoodType;
import com.hseproject.proj.model.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepo extends CrudRepository<Food, Long> {

    List<Food> findByTypeAndTagsContains(FoodType type, Tag tag);
}
