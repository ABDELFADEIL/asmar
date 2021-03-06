package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.ProductDetailDTO;
import com.aston.ecommerce.asmar.entity.Product;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class, ImageMapper.class})
public interface ProductMapper {

    ProductDTO toProductDto(Product product);
    ProductDetailDTO toProductDetailDto(Product product);
    List<ProductDetailDTO> toProductDetailDtos(List<Product> products);
    List<ProductDTO> toProductDtos(List<Product> products);

    Product toProduct(ProductDTO productDTO);
    List<Product> toProducts(List<ProductDTO> productDTOS);
}
