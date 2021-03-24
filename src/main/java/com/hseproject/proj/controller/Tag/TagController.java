package com.hseproject.proj.controller.Tag;

import com.hseproject.proj.service.Tag.TagService;
import com.hseproject.proj.view.TagAddView;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {

    final
    TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping()
    public void getTag() {
        tagService.getAll().forEach(System.out::println);
    }

    @PostMapping()
    public void saveTag(@RequestBody TagAddView tagAddView) {
        tagService.add(tagAddView);
    }
}
