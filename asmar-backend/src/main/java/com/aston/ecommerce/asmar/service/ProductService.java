package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.ProductDto;
import com.aston.ecommerce.asmar.entity.Product;

import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductService {


    Page<ProductDto> getProductByLabelOrDescriptionPage();

    Product getProductById(Integer id);

    List<ProductDto> mapperProductToProductDto(List<Product> products);

    }


