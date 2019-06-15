package com.example.demo.service.CategoryService;
import com.example.demo.repository.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CategoryService {
    void add(Category category);

    void delete(Integer id);

    void update(Category category);

    ArrayList<Category> findAll();

    Category findById(Integer id);

    ArrayList<Category> getByPage(Integer pageNumber);

    Integer getAutoId();
}
