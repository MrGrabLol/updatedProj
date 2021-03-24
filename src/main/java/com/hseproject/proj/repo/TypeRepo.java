package com.hseproject.proj.repo;

import com.hseproject.proj.model.FoodType;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepo extends CrudRepository<FoodType, Long> {
}
