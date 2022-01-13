package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.entity.Product;

import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductService {


    Page<ProductDTO> getProductByLabelOrDescriptionPage();

    Product getProductById(Integer id);

    List<ProductDTO> mapperProductToProductDto(List<Product> products);

    }


