package com.hseproject.proj.service.Food;

import com.hseproject.proj.model.Category;
import com.hseproject.proj.model.Food;
import com.hseproject.proj.model.Tag;
import com.hseproject.proj.repo.FoodRepo;
import com.hseproject.proj.repo.TagRepo;
import com.hseproject.proj.repo.TypeRepo;
import com.hseproject.proj.view.FoodAddView;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FoodServiceImpl implements FoodService {

    final FoodRepo foodRepository;

    final TagRepo tagRepo;

    final TypeRepo typeRepo;

    final EntityManager em;

    public FoodServiceImpl(FoodRepo foodRepository, TagRepo tagRepo, TypeRepo typeRepo, EntityManager em) {
        this.foodRepository = foodRepository;
        this.tagRepo = tagRepo;
        this.typeRepo = typeRepo;
        this.em = em;
    }

    @Override
    public void add(FoodAddView food) {
        List<Long> comp = food.tags;
        List<Tag> tags = new ArrayList<>();
        for (Long c : comp) {
            tags.add(tagRepo.findById(c).orElse(null));
        }
        Category type = typeRepo.findById(food.type).orElse(null);
        Food f = new Food(food.name, food.price, tags, type);
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

    public List<Food> getFoodByCategory(Category id) {
        TypedQuery<Food> query = em.createQuery("SELECT m FROM Food m where m.category = :category", Food.class);
        query.setParameter("category", id);
        return query.getResultList();
    }

}
