package com.example.demo.controller;

import com.example.demo.repository.model.Article;
import com.example.demo.repository.model.Category;
import com.example.demo.service.ArticleService.ArticleService;
import com.example.demo.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class ArticleController {

    static int currentPage = 1;

    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/home")
    public String home() {
        return "redirect:/";
    }

    @GetMapping(value = {"/viewAll", "/index", "/"})
    public String showData(ModelMap modelMap) {
        modelMap.addAttribute("articles", articleService.getByPage(1));
        showBypage(1, modelMap);
        modelMap.addAttribute("total", articleService.findAll().size());

        return "index";
    }
@GetMapping("/search")
public String SearchById(){
        return "";
}
    @GetMapping(value = {"/pagenation"})
    public String showBypage(@RequestParam(name = "page") int page, ModelMap modelMap) {
        System.out.println(getPagenation().size());

        if (page == -2) {
            page = 1;
        }
        if (page == -3) {
            page = getPagenation().size();
        }

        if (page == -59) {
            if (currentPage == 1) {
                currentPage = getPagenation().size() + 1;
            }
            page = --currentPage;
        }

        if (page == -4) {
            if (currentPage == getPagenation().size()) {
                currentPage = 0;
            }
            page = ++currentPage;
        }

        System.out.println(page);

        currentPage = page;
        modelMap.addAttribute("articles", articleService.getByPage(page));
        ArrayList tmp = new ArrayList<>();

        if (getPagenation().size() > 6) {
            if (page == 1) {
                page++;
            }
            if (getPagenation().size() - page <= 4) {
                for (Integer i = getPagenation().size() - 6; i < getPagenation().size(); i++) {
                    tmp.add(i + 1);
                }
            } else {
                for (Integer i = page - 1; i < page + 2; i++) {
                    tmp.add(i);
                    if (i == page + 1) {
                        tmp.add(-1);
                    }
                }
                for (Integer i = getPagenation().size() - 3; i < getPagenation().size(); i++) {
                    tmp.add(i + 1);
                }
                modelMap.addAttribute("st", "-1");
            }
        } else {
            tmp.addAll(getPagenation());
        }
        modelMap.addAttribute("pages", tmp);
        modelMap.addAttribute("total", articleService.findAll().size());

        return "index";
    }

    ArrayList getPagenation() {
        ArrayList arr = new ArrayList();

        int n = articleService.findAll().size() / 10;
        if (articleService.findAll().size() % 10 != 0) {
            n++;
        }

        for (int i = 1; i < n + 1; i++) {
            arr.add(i);
        }
        return arr;
    }

    @GetMapping("/update")
    String updateForm(ModelMap modelMap, @RequestParam(name = "id") Integer id) {

        modelMap.addAttribute("article", articleService.findById(id));
        System.out.println( articleService.findById(id));
        modelMap.addAttribute("st", -1);
        modelMap.addAttribute("cate",categoryService.findAll());
        return "InputForm";

    }

    @PostMapping("/updateArticle")
    String Edit(@ModelAttribute Article article, @RequestParam("file") MultipartFile file, @RequestParam(name = "category") Integer c) {

        article.setImg(configImage(file));
article.setCategory(categoryService.findById(c));
        if (file.isEmpty()) {
            article.setImg(articleService.findById(article.getId()).getImg());
        }

        try {
            Files.copy(file.getInputStream(), Paths.get("C:/Users/ASUS/Desktop/ArticleManagement/src/main/resources/static/img", file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        articleService.update(article);
        return "redirect:/viewAll";
    }

    @GetMapping("/add")
    String form(ModelMap modelMap) {
        int idAuto;
        if (articleService.findAll().size() == 0) {
            idAuto = 0;
        }
        else {
            idAuto = articleService.findAll().get(articleService.findAll().size() - 1).getId();
        }
        modelMap.addAttribute("article", new Article(idAuto + 1, "", "",new Category(), "", "user.png"));
        modelMap.addAttribute("total", articleService.findAll().size());
        modelMap.addAttribute("cate",categoryService.findAll());
        return "InputForm";
    }

    @PostMapping("/addArticle")
    public String addData(@ModelAttribute Article article, @RequestParam("file") MultipartFile file,@RequestParam Integer category) {

        article.setImg(configImage(file));
        article.setCategory(categoryService.findById(category));
        articleService.addArticle(article);
        System.out.println(articleService.findAll());
        return "redirect:/viewAll";
    }

    private String configImage(MultipartFile file) {
        UUID random = UUID.randomUUID();
        String fileName;
        if (file.isEmpty()) {
            fileName = "user.png";
        } else {
            String f = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            fileName = random + f;
            try {
                Files.copy(file.getInputStream(), Paths.get("src/main/resources/static/img/", fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return fileName;
    }


    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        System.out.println("seasdfa");
        articleService.delete(id);
        return "redirect:/viewAll";
    }

    @GetMapping("/view")
    String showByID(@RequestParam Integer id, ModelMap modelMap) {
        modelMap.addAttribute("article", articleService.findById(id));
        System.out.println(articleService.findById(id));
        return "detial";
    }

    @GetMapping("/cancel")
    String Cancel() {
        return "redirect:/viewAll";
    }
}
