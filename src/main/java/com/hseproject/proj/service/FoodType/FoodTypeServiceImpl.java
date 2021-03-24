package com.hseproject.proj.service.FoodType;

import com.hseproject.proj.model.FoodType;
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
        FoodType t = new FoodType(type.name);
        foodTypeRepository.save(t);
    }

    @Override
    public void edit(FoodType type) {
        foodTypeRepository.save(type);
    }

    @Override
    public void delete(FoodType type) {
        foodTypeRepository.save(type);
    }

    @Override
    public FoodType getById(Long id) {
        return foodTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<FoodType> getAll() {
        return StreamSupport.stream(foodTypeRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
