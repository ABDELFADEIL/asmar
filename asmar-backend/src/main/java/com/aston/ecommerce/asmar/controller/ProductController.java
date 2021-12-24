package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDto;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;


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
    @ApiOperation(value = "Return product detail by product id")
    @ApiResponses(value = {
                  @ApiResponse(code = 200, message = "Return product detail"),
                  @ApiResponse(code = 204, message = "No content"),
                  @ApiResponse(code = 404, message = "product not found"),
                  @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<Product> getProduct(
                  @RequestParam(name = "productId" , required = true) int id
                  )
    {
        Product product = this.productService.getProductById(id);
        if(product == null){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity(product, HttpStatus.OK);
    }




}
