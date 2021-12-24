package com.aston.ecommerce.asmar.service;


import com.aston.ecommerce.asmar.dto.ProductDetail;
import com.aston.ecommerce.asmar.dto.ProductDto;
import com.aston.ecommerce.asmar.entity.Product;

import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductService {

    Page<Product> getProducts(int page, int size, String productLabel);

    Product addProduct(ProductDetail productDetail);

    Product getProductById(int id);

    Page<ProductDto> getProductByLabelOrDescriptionPage();

    ProductDetail getProductDetail(String label);

    List<ProductDto> mapperProductToProductDto(List<Product> products);

    }


