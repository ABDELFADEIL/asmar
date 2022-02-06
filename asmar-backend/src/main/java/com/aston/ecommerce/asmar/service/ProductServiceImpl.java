package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.CategoryRepository;
import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.ProductDetailDTO;
import com.aston.ecommerce.asmar.dto.mapper.ProductMapper;
import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.exption.ProductExpception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public ProductDetailDTO getProductById(Long id) {
         Product product = productRepository.getById(id);
        return productMapper.toProductDetailDto(product);
    }



    public List<ProductDTO> getProductByLabelOrDescription(String keyword) {
        List<Product> products;
              if (keyword != null) {
                  products =  productRepository.findProductsByLabelOrderByDescription(keyword);
                  return productMapper.toProductDtos(products);
            }
        products =  productRepository.findAll();
        return productMapper.toProductDtos(products);
        }



    @Override
    public List<ProductDTO> getProductsByCategoryId(Long categoryId){
        List<Product> products = productRepository.getProductsByCategoryId(categoryId);
        return productMapper.toProductDtos(products);
        }

    @Override
    public List<ProductDTO> findAll() {
        return productMapper.toProductDtos(productRepository.findAll());
    }

    @Override
    public ProductDetailDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Category category = categoryRepository.getById(productDTO.getCategory().getId());
        if (category== null){
            throw new ProductExpception("category not found " + category);
        }
        product.setCategory(category);
        product = productRepository.save(product);
        return productMapper.toProductDetailDto(product);
    }


}