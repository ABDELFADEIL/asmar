package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDTO toProductDto(Product product);
    List<ProductDTO> toProductDtos(List<Product> products);

    Product toProduct(ProductDTO productDTO);
    List<Product> toProducts(List<ProductDTO> productDTOS);
}
