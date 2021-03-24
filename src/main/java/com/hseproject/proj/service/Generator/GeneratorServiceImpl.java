package com.hseproject.proj.service.Generator;

import com.hseproject.proj.model.Food;
import com.hseproject.proj.model.FoodType;
import com.hseproject.proj.model.Tag;
import com.hseproject.proj.repo.FoodRepo;
import com.hseproject.proj.repo.TagRepo;
import com.hseproject.proj.repo.TypeRepo;
import com.hseproject.proj.view.GenerateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    TypeRepo typeRepo;

    @Autowired
    TagRepo tagRepo;

    @Autowired
    FoodRepo foodRepo;

    @Override
    public List<Food> generate(GenerateView view) {
        Random random = new Random();
        List<Long> types = view.type;
        List<Long> tags = view.tags;
        List<Tag> tagList = new ArrayList<>();
        List<FoodType> foodTypeList = new ArrayList<>();
        List<Food> out = new ArrayList<>();
        for (Long type : types) {
            foodTypeList.add(typeRepo.findById(type).orElse(null));
        }
        for (Long tag : tags) {
            tagList.add(tagRepo.findById(tag).orElse(null));
        }
        for (FoodType type : foodTypeList) {
            List<Food> all = new ArrayList<>();
            for (Tag tag : tagList) {
                all = foodRepo.findByTypeAndTagsContains(type, tag);
            }
            out.add(all.get(random.nextInt(all.size())));
        }
        return out;
    }
}
