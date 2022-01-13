package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.CategoryRepository;
import com.aston.ecommerce.asmar.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Page<Category>getCategoryList(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
