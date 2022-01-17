package com.aston.ecommerce.asmar.controller;


import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aston.ecommerce.asmar.dao.ProductRepository;
import org.springframework.web.bind.annotation.*;
import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDetailDto;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private final ProductService productService;

    private final ProductRepository productRepository;


    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }


 /*   @GetMapping("/product-by-id")

    public Product getProduct(
                  @RequestParam(name = "productId" , required = true) Long id
                  ) {

        Product product = this.productService.getProductById(id);
        if (product == null) {
            return null;//ResponseEntity.noContent().build();
        }
        return product;
    }*/
    /* get list of product*/
    @GetMapping("/list")
    public ResponseEntity<Page<Product>> getProducts(
            @RequestParam(value = "offset", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("label"));

        return ResponseEntity.ok(productService.getProductList(pageable));

    }

    /* get product list by category */
    @GetMapping("/category/{categoryId}")
    @ApiOperation(value = "Return list of product by category id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return product list"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "product list not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public List<Product> getProductsByCategoryId(
            @PathVariable(name = "categoryId") Long categoryId){
             return this.productService.getProductsByCategoryId(categoryId);
    }

    /* get product by id */
    @GetMapping("/{id}")
    @ApiOperation(value = "Return product by product id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return product by id"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "product not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<ProductDetailDto> getProductById(
            @PathVariable(name = "id") Long id) {
        Product product = this.productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.noContent().build();
        }
      /*  return new ResponseEntity<>(product, HttpStatus.OK);*/
        return ResponseEntity.ok(productService.mapperProductToProductDetailDto(product));
    }

    /*get products by label or description*/
    @GetMapping
    @ApiOperation(value = "Get List of products by label or description")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return the list of products by label or description"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "product not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<ProductDTO>> Search(@Param("keyword") String keyword) {
        List<Product> listProducts = productService.getProductByLabelOrDescription(keyword);
        if (listProducts.isEmpty()) {
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(productService.mapperProductToProductDto(listProducts));
    }
}
