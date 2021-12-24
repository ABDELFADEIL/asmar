package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDetail;
import com.aston.ecommerce.asmar.dto.ProductDto;
import com.aston.ecommerce.asmar.entity.Image;
import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getProducts(int page, int size, String productLabel) {
        return null;
    }

    @Override
    public Product addProduct(ProductDetail productDetail) {
        return null;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public Page<ProductDto> getProductByLabelOrDescriptionPage() {
        return null;
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
    public ProductDetail getProductDetail(String label) {
        return null;
    }

}
