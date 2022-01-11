package com.aston.ecommerce.asmar.service;



import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.SubCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    List<SubCategory> getSubCategoriesByCategory(Category category);

    Page<Category> getCategoryList(Pageable pageable);
}
