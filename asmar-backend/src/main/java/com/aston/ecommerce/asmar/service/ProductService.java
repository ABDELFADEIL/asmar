package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.ProductDetailDTO;
import com.aston.ecommerce.asmar.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductByLabelOrDescription(String keyword);
    ProductDetailDTO getProductById(Integer id);
    List<ProductDetailDTO> getProductsByDate(Integer nb);
    Product findById(Integer id);
    List<ProductDTO> getProductsByCategoryId(Integer categoryId);
    List<ProductDTO> findAll();
    ProductDetailDTO addProduct(ProductDTO productDTO);
}


