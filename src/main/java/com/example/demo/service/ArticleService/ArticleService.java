package com.example.demo.service.ArticleService;

import com.example.demo.repository.model.Article;

import java.util.ArrayList;

public interface ArticleService {

    void addArticle(Article article);

    void delete(Integer  id);

    void update(Article article);

    ArrayList<Article> findAll();

    Article findById(Integer id);

    ArrayList<Article> getByPage(Integer pageNumber);

}
