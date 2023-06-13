package com.vcr.vcr_project.repository;

import com.vcr.vcr_project.model.Category;
import com.vcr.vcr_project.model.request.CategoryRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryRepository {
    @Select("""
            insert into category(name)values(#{cate.name}) returning *
            """)
    @Results(id = "categoryId", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    }
    )
    Category addNewCategory(@Param("cate") CategoryRequest categoryRequest);
    @Select("""
            select * from category
            """)
    @ResultMap("categoryId")
    List<Category>getAllCategories();
    @Select("""
            update category set name=#{cate.name} where id=#{id} returning *
            """)
    Category updateCategory(Integer id,@Param("cate") CategoryRequest categoryRequest);
    @Select("""
            select * from category where id=#{id}
            """)
    @ResultMap("categoryId")
    Category getCategoryById(Integer id);
}
