package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDetailDto;
import com.aston.ecommerce.asmar.dto.ProductDto;
import com.aston.ecommerce.asmar.entity.Image;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getProductList(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

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
    public ProductDetailDto mapperProductToProductDetailDto(Product product){

        ProductDetailDto productDetail = new ProductDetailDto();
            productDetail.setLabel(product.getLabel());
            productDetail.setPrice(product.getPrice());
            productDetail.setDescription(product.getDescription());
            productDetail.setHistory(product.getHistory());
            productDetail.setOrigin(product.getOrigin());
            productDetail.setComposition(product.getComposition());
            productDetail.setUsage(product.getUsage());
            productDetail.setSize(product.getSize());
            productDetail.setDisponible(product.isDisponible());
            productDetail.setQuantity(product.getQuantity());
            productDetail.setUrlImages((product.getUrlImages()));

        return productDetail;
    }


    @Override
    public List<Product> getProductsBySbuCategory(SubCategory subCategory){

        return productRepository.findProductsBySubCategory(subCategory);
        }


}


