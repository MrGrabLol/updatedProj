package com.hseproject.proj.service.Food;

import com.hseproject.proj.model.Food;
import com.hseproject.proj.model.FoodType;
import com.hseproject.proj.model.Tag;
import com.hseproject.proj.repo.FoodRepo;
import com.hseproject.proj.repo.TagRepo;
import com.hseproject.proj.repo.TypeRepo;
import com.hseproject.proj.view.FoodAddView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.StartupStep;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepo foodRepository;

    @Autowired
    TagRepo tagRepo;

    @Autowired
    TypeRepo typeRepo;

    @Override
    public void add(FoodAddView food) {
        List<Long> comp = food.tags;
        List<Tag> tags = new ArrayList<>();
        for (Long c : comp) {
            tags.add(tagRepo.findById(c).orElse(null));
        }
        FoodType type = typeRepo.findById(food.type).orElse(null);
        Food f = new Food(food.name, food.price, food.composition, tags, type);
        foodRepository.save(f);
    }

    @Override
    public void edit(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void delete(Food food) {
        foodRepository.save(food);
    }

    @Override
    public Food getById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    @Override
    public List<Food> getAll() {
        return StreamSupport.stream(foodRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
