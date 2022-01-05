package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.ProductDto;
import com.aston.ecommerce.asmar.entity.Product;

import java.util.List;


public interface ProductService {


    List<Product> getProductByLabelOrDescription(String keyword);

    Product getProductById(Integer id);

    List<ProductDto> mapperProductToProductDto(List<Product> products);

    List<Product> getProductsBySbuCategoryId(Integer sub_category_id);

}


