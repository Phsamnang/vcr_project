package com.vcr.vcr_project.repository;

import com.vcr.vcr_project.model.Category;
import com.vcr.vcr_project.model.Product;
import com.vcr.vcr_project.model.request.ProductRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepository {
    @Select("""
            insert into product(cate_id,pro_name,price) values (#{pro.cate_id},#{pro.name},#{pro.price}) returning *
            """)
    @Results(id = "productId",value = {
            @Result(property = "name",column = "pro_name")
    })
    @ResultMap("productId")
    Product addNewProduct(@Param("pro")ProductRequest request);
    @Select("""
            select * from product
            """)
    @Results(id = "productId",value = {
            @Result(property = "name",column = "pro_name"),
            @Result(property = "category",column = "cate_id",one = @One(select = "com.vcr.vcr_project.repository.CategoryRepository.getCategoryById"))
    })
    List<Product> getAllCategories();

}
