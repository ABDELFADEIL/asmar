package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aston.ecommerce.asmar.dao.ProductRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {



    private final ProductService productService;

    private final ProductRepository productRepository;


    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/product-by-id")

    public Product getProduct(
                  @RequestParam(name = "productId" , required = true) int id
                  )
    {

        Product product = this.productService.getProductById(id);
        if(product == null){
            return null;//ResponseEntity.noContent().build();
        }
        return product;
    }




}
