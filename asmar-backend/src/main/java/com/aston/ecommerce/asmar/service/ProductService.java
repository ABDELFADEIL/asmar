package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.ProductDetailDto;
import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {

    Page<ProductDTO> getProductByLabelOrDescriptionPage();
    List<Product> getProductByLabelOrDescription(String keyword);

    Product getProductById(Long id);

    List<ProductDTO> mapperProductToProductDto(List<Product> products);

    ProductDetailDto mapperProductToProductDetailDto(Product product);

    List<Product> getProductsByCategoryId(Long categoryId);

    Page<Product> getProductList(Pageable pageable);

}


