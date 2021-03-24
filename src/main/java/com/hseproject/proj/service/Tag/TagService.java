package com.hseproject.proj.service.Tag;

import com.hseproject.proj.model.Tag;
import com.hseproject.proj.view.TagAddView;

import java.util.List;

public interface TagService {

    void add(TagAddView tag);

    void edit(Tag tag);

    void delete(Tag tag);

    Tag getById(Long id);

    List<Tag> getAll();
}
