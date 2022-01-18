package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.ProductDetailDTO;
import com.aston.ecommerce.asmar.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductByLabelOrDescription(String keyword);
    ProductDetailDTO getProductById(Long id);
    List<ProductDTO> getProductsByCategoryId(Long categoryId);
    List<Product> findAll();
}


