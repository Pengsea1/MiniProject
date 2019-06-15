package com.example.demo.service.CategoryService;
import com.example.demo.repository.model.Category;

import java.util.ArrayList;


public interface CategoryService {
    void add(Category category);

    void delete(Integer id);

    void update(Category category);

    ArrayList<Category> findAll();

    Category findById(Integer id);

    ArrayList<Category> getByPage(Integer pageNumber);

    Integer getAutoId();
}
