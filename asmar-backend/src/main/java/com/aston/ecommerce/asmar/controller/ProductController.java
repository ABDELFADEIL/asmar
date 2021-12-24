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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/api/produits")
public class ProductController {


    private final ProductService productService;

    private final ProductRepository productRepository;


    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping
    @ApiOperation(value = "Return list of products searched by label")
    @ApiResponses(value = {
                  @ApiResponse(code = 200, message = "Return list of products by label"),
                  @ApiResponse(code = 204, message = "No content"),
                  @ApiResponse(code = 404, message = "product no found"),
                  @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<Page<ProductDto>> getProductsByLabelOrDescription(
                  @ApiParam(value = "page number", name = "page") @RequestParam(name = "page" , defaultValue = "1", required = false)
                  @Positive(message = "page must be more than 0" ) int page,
                  @ApiParam(value = "page size" , name = "size") @RequestParam(name = "size" , defaultValue = "10" , required= false)
                  @Positive(message = "size must be more than 0") int size,
                  @ApiParam(value = "product label or product description" , name = "productLabel")
                  @RequestParam(name = "productLabel" , required = false) String productLabel)
    {
        Page<Product> products = this.productService.getProducts(page, size, productLabel);
        if(products.isEmpty())
            return ResponseEntity.noContent().build();
            return new ResponseEntity(products, HttpStatus.OK);
    }


}
