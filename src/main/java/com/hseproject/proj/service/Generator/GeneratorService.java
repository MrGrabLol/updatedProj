package com.hseproject.proj.service.Generator;

import com.hseproject.proj.model.Food;
import com.hseproject.proj.view.GenerateView;

import java.util.List;

public interface GeneratorService {

    List<Food> generate(GenerateView view);

}
