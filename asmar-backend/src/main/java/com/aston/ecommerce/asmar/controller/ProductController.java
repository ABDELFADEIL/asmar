package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDto;
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
import org.springframework.http.HttpStatus;
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

    /* get list of product*/
    @GetMapping("/list")
    public ResponseEntity<Page<Product>> getProductlist(
            @RequestParam(value = "offset", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("label"));

        return ResponseEntity.ok(productService.getProductList(pageable));

    }

    /* get product list by sub-category */
    @GetMapping("/subCategory/{subCategory_id}")
    @ApiOperation(value = "Return list of product by subcategory id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return product list"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "product list not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public List<Product> getProductsBySubcategoryId(
            @PathVariable(name = "subCategory_id") Integer subCategoryId){
             return this.productService.getProductsBySbuCategory(subCategoryId);
    }

    /* get product by id */
    @GetMapping("/{id}")
    @ApiOperation(value = "Return product detail by product id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return product detail"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "product not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<Product> getProductById(
            @PathVariable(name = "id") Integer id) {
        Product product = this.productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    /*get products by label or description*/
    @GetMapping
    @ApiOperation(value = "Get List of products by label or description")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return the list of products by label or description"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "product not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<ProductDto>> Search(@Param("keyword") String keyword) {
        List<Product> listProducts = productService.getProductByLabelOrDescription(keyword);
        if (listProducts.isEmpty()) {
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(productService.mapperProductToProductDto(listProducts));
    }
}
