package com.aston.ecommerce.asmar.service;



import com.aston.ecommerce.asmar.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface CategoryService {


    Page<Category> getCategoryList(Pageable pageable);
}
