package com.example.demo.repository;

import com.example.demo.repository.ArticleRepository.CategoryRepository;
import com.example.demo.repository.model.Category;
import com.example.demo.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void add(Category category) {
        categoryRepository.add(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryRepository.update(category);
    }

    @Override
    public ArrayList<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public ArrayList<Category> getByPage(Integer pageNumber) {
        return categoryRepository.getByPage(pageNumber);
    }

    @Override
    public Integer getAutoId() {
        return categoryRepository.getAutoId();
    }
}
