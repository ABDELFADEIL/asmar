package com.aston.ecommerce.asmar.service;



import com.aston.ecommerce.asmar.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {


    Page<Category> getCategoryList(Pageable pageable);
}
