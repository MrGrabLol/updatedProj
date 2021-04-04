package com.hseproject.proj.service.FoodType;

import com.hseproject.proj.model.Category;
import com.hseproject.proj.repo.TypeRepo;
import com.hseproject.proj.view.TypeAddView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FoodTypeServiceImpl implements FoodTypeService {

    @Autowired
    TypeRepo foodTypeRepository;

    @Override
    public void add(TypeAddView type) {
        Category t = new Category(type.name);
        foodTypeRepository.save(t);
    }

    @Override
    public void edit(Category type) {
        foodTypeRepository.save(type);
    }

    @Override
    public void delete(Category type) {
        foodTypeRepository.save(type);
    }

    @Override
    public Category getById(Long id) {
        return foodTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return StreamSupport.stream(foodTypeRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
