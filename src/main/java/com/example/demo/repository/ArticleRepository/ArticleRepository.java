package com.example.demo.repository.ArticleRepository;

import com.example.demo.repository.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
@Repository
public interface ArticleRepository {
    @Select("SELECT * FROM TBARTICLE as a join tbcategory as c on a.cateid=c.cateid where a.TITLE ilike '%'||#{title}||'%'")
    @Results(
            {
                    @Result(column = "cateId",property = "category.cateId"),
                    @Result(column = "CATETITLE",property = "category.cateTitle")
            }
    )
    ArrayList<Article> searchByName(String title);

    @Insert("insert into tbArticle (title,CATEID,author,des,img) values(#{title},#{category.cateId},#{author},#{des},#{img})")
    void addArticle(Article article);

    @Delete("delete from tbArticle where id=#{id}")
    void deleteArticle(Integer id);

    @Update("UPDATE tbArticle SET title = #{title},author=#{author},cateId=#{category.cateId},des=#{des},img=#{img} WHERE id=#{id}")
    void updateArticle(Article article);

    @Select("SELECT * FROM TBARTICLE as a join tbcategory as c on a.cateid=c.cateid")
    @Results(
            {
                    @Result(column = "cateId",property = "category.cateId"),
                    @Result(column = "CATETITLE",property = "category.cateTitle")
            }
    )
    ArrayList<Article> findAll();

    @Select("SELECT * FROM TBARTICLE as a join tbcategory as c on a.cateid=c.cateid where a.id=#{id} ")
    @Results(
            {
                    @Result(column = "cateId",property = "category.cateId"),
                    @Result(column = "CATETITLE",property = "category.cateTitle")
            }
    )
    Article findById(Integer id);

    @Select("select * from tbArticle as a join tbcategory as c on a.cateid=c.cateid LIMIT 10 OFFSET 10*(#{pageNumber}-1)")
    @Results(
            {
                    @Result(column = "cateId",property = "category.cateId"),
                    @Result(column = "CATETITLE",property = "category.cateTitle")
            }
    )

    ArrayList<Article> getByPage(Integer pageNumber);

}
