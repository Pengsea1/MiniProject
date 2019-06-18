package com.example.demo.service;

import com.example.demo.repository.ArticleRepository.ArticleRepository;
import com.example.demo.repository.model.Article;
import com.example.demo.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ArticleServiceImp implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void addArticle(Article article) {
        System.out.println("jhahahha");
        articleRepository.addArticle(article);
    }

    @Override
    public void delete(Integer id) {
        articleRepository.deleteArticle(id);
    }

    @Override
    public void update(Article article) {
        articleRepository.updateArticle(article);
    }

    @Override
    public ArrayList<Article> findAll() {

        return articleRepository.findAll();
    }

    @Override
    public Article findById(Integer id) {
        return articleRepository.findById(id);
    }

    @Override
    public ArrayList<Article> getByPage(Integer pageNumber) {
        return articleRepository.getByPage(pageNumber);
    }

    @Override
    public ArrayList<Article> searchByTitle(String title) {
        return articleRepository.searchByTitle(title);
    }

    @Override
    public ArrayList<Article> searchByCategory(Integer id) {
        System.out.println(id);
        return articleRepository.searchByCategory(id);
    }
}
