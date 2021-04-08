package com.hseproject.proj.service.Generator;

import com.hseproject.proj.model.Category;
import com.hseproject.proj.model.Food;
import com.hseproject.proj.model.Tag;
import com.hseproject.proj.repo.FoodRepo;
import com.hseproject.proj.repo.TagRepo;
import com.hseproject.proj.repo.TypeRepo;
import com.hseproject.proj.view.GenerateView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    final
    TypeRepo typeRepo;

    final
    TagRepo tagRepo;

    final
    FoodRepo foodRepo;

    public GeneratorServiceImpl(TypeRepo typeRepo, TagRepo tagRepo, FoodRepo foodRepo) {
        this.typeRepo = typeRepo;
        this.tagRepo = tagRepo;
        this.foodRepo = foodRepo;
    }

    @Override
    public List<Food> generate(GenerateView view) {
        List<Category> types = view.type;
        List<Tag> tags = view.tags;
        List<Food> out = new ArrayList<>();
        for (Category type : types) {
            List<Food> all = new ArrayList<>();
            if (tags == null || tags.isEmpty()) {
                all = foodRepo.findByCategory(type);
            } else {
                for (Tag tag : tags) {
                    all = foodRepo.findByCategoryAndTagContains(type, tag);
                }
            }
            out.add(all.get(new Random().nextInt(all.size())));
        }
        return out;
    }
}
