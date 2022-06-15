package com.aston.ecommerce.asmar.controller;


import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.ProductDetailDTO;
import com.aston.ecommerce.asmar.service.IProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    /* get product list by category */
    @GetMapping("/category/{categoryId}")
    @ApiOperation(value = "Return list of product by category id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return product list"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "product list not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public List<ProductDTO> getProductsByCategoryId(
            @PathVariable(name = "categoryId") Integer categoryId){
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
    public ResponseEntity<ProductDetailDTO> get(
            @PathVariable(name = "id") Integer id) {
        ProductDetailDTO product = this.productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.noContent().build();
        }
        /*  return new ResponseEntity<>(product, HttpStatus.OK);*/
        return ResponseEntity.ok(product);
    }
    
     
    @GetMapping("/bydate/{nb}")
    @ApiOperation(value = "Return list of n products by creation date")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return list of products sorted by date"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "products not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<ProductDetailDTO>> getProductsByDate(
            @PathVariable Integer nb) {
    	List<ProductDetailDTO> listProducts = this.productService.getProductsByDate(nb);
        if (listProducts == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listProducts);
    }

    /*get products by label or description*/
    @GetMapping("/search")
    @ApiOperation(value = "Get List of products by label or description")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return the list of products by label or description"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "product not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<ProductDTO>> search(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<ProductDTO> listProducts = productService.getProductByLabelOrDescription(keyword);
        if (listProducts.isEmpty()) {
            return new ResponseEntity<>(listProducts, HttpStatus.NO_CONTENT);

        }
        return ResponseEntity.ok(listProducts);
    }

    /*get all products */
    @GetMapping("/all")
    @ApiOperation(value = "Get List of all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return the list of all products"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "products not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> listProducts = productService.findAll();
        if (listProducts.isEmpty()) {
            return new ResponseEntity<>(listProducts, HttpStatus.NO_CONTENT);

        }
        return ResponseEntity.ok(listProducts);
    }

    /*get all products */
    @PostMapping("/add")
    @ApiOperation(value = "add product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "product added"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<ProductDetailDTO> addProduct(@RequestBody ProductDTO productDTO) {
        ProductDetailDTO productDetailDTO = null;
        productDetailDTO = productService.addProduct(productDTO);
        if (productDetailDTO == null) {
            return new ResponseEntity<>(productDetailDTO, HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(productDetailDTO, HttpStatus.CREATED);
    }

    /*add product by category*/
}