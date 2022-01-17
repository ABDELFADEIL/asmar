package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.mapper.ProductMapper;
import com.aston.ecommerce.asmar.entity.*;
import com.aston.ecommerce.asmar.dto.ProductDetailDto;
import com.aston.ecommerce.asmar.entity.Image;
import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;



    @Override
    public ProductDetailDto getProductById(Long id) {
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


}