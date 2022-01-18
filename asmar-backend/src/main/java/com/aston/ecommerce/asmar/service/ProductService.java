package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.ProductDetailDto;
import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductByLabelOrDescription(String keyword);
    ProductDetailDto getProductById(Long id);
    List<ProductDTO> getProductsByCategoryId(Long categoryId);


}


