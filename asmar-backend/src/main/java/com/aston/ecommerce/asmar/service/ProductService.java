package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.ProductDto;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.SubCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {


    List<Product> getProductByLabelOrDescription(String keyword);

    Product getProductById(Integer id);

    List<ProductDto> mapperProductToProductDto(List<Product> products);

    List<Product> getProductsBySbuCategory(SubCategory subCategory);

    Page<Product> getProductList(Pageable pageable);

}


