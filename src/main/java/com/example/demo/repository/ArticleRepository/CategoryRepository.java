package com.example.demo.repository.ArticleRepository;

import com.example.demo.repository.model.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CategoryRepository {
    @Insert("Insert into tbcategory(catetitle) values(#{cateTitle})")
    void add(Category category);

    @Delete("delete from tbcategory where cateId=#{id}")
    void delete(Integer id);

    @Update("Update tbcategory set CateTitle=#{cateTitle} where cateId=#{cateId}")
    void update(Category category);

    @Select("SELECT * FROM TBCATEGORY")
    @Results({
            @Result(property = "cateId",column = "CATEID"),
            @Result(property = "cateTitle",column = "CATETITLE")
    })
    ArrayList<Category> findAll();

    @Select("select * from tbCategory where cateId=#{id}")
    Category findById(Integer id);

    ArrayList<Category> getByPage(Integer pageNumber);

    @Select("SELECT Max(CateId) FROM tbcategory")
    Integer getAutoId();

}
