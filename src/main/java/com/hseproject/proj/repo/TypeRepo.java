package com.hseproject.proj.repo;

import com.hseproject.proj.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends CrudRepository<Category, Long> {
}
