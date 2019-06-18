//package com.example.demo.repository;
//import com.example.demo.repository.ArticleRepository.ArticleRepository;
//import com.example.demo.repository.model.Article;
//import org.springframework.stereotype.Repository;
//import java.util.ArrayList;
//
//@Repository
//public class ArticleRepositoryImp implements ArticleRepository {
//    ArrayList<Article> arr = new ArrayList<>();
//
//    public ArticleRepositoryImp() {
//        for (int i = 1; i < 85; i++) {
//            arr.addArticle(new Article(i, "Java", "Pengsea", "GOOD", "user.png"));
//        }
//    }
//
//    @Override
//    public void addArticle(Article article) {
//        arr.addArticle(article);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i).getId() == id) {
//                arr.remove(arr.get(i));
//                return;
//            }
//        }
//    }
//
//    @Override
//    public void updateArticle(Article newArticle) {
//        for (Article article : arr) {
//            if (article.getId() == newArticle.getId()) {
//                article.setAuthor(newArticle.getAuthor());
//                article.setTitle(newArticle.getTitle());
//                article.setDes(newArticle.getDes());
//                article.setImg(newArticle.getImg());
//                return;
//            }
//        }
//    }
//
//    @Override
//    public ArrayList<Article> findAll() {
//        return arr;
//    }
//
//    @Override
//    public Article findById(Integer id) {
//        for (Article article : arr) {
//            if (article.getId() == id) {
//                return article;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public ArrayList<Article> getByPage(Integer pageNumber) {
//        int startIndex = pageNumber * 10 - 10;
//        int endIndex = pageNumber * 10;
//        int n =arr.size() / 10;
//        if (arr.size() % 10 != 0) {
//            n++;
//        }
//        if (pageNumber == n) {
//            endIndex = arr.size() ;
//        }
//        ArrayList<Article> tmp = new ArrayList<>();
//        for (int i = startIndex; i < endIndex; i++) {
//            tmp.addArticle(arr.get(i));
//        }
//        return tmp;
//    }
//}