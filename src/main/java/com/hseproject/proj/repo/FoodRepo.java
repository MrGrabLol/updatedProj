package com.hseproject.proj.repo;

import com.hseproject.proj.model.Category;
import com.hseproject.proj.model.Food;
import com.hseproject.proj.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepo extends CrudRepository<Food, Long> {

    List<Food> findByCategory(Category category);

    List<Food> findByCategoryAndTagContains(Category type, Tag tag);
}
