package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDto;
import com.aston.ecommerce.asmar.entity.Image;
import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(Integer id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getProductByLabelOrDescription(String keyword) {
              if (keyword != null) {
                return productRepository.findProductsByLabelOrderByDescription(keyword);
            }
            return productRepository.findAll();
        }

    @Override
    public List<ProductDto> mapperProductToProductDto(List<Product> products){
        List<ProductDto> productDtoList = new ArrayList<>();

        // boucle sur la list de products
        for (Product product: products){
            ProductDto productDto = new ProductDto();
            productDto.setProductLabel(product.getLabel());
            productDto.setPrice(product.getPrice());
            Image image = new Image();
            for (Image image1: product.getUrlImages()){
                if(image1.isPrincipal()){
                    image = image1;
                }
            }

            productDto.setImage(image);
            productDtoList.add(productDto);
        }

        return productDtoList;
    }

    @Override
    public List<Product> getProductsBySbuCategoryId(Integer sub_category_id) {

            return productRepository.getProductsBySubCategory(sub_category_id);
        }

    }


