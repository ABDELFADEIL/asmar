package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.AddressDTO;
import com.aston.ecommerce.asmar.dto.CategoryDTO;
import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.entity.Address;
import com.aston.ecommerce.asmar.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toCategoryDto(Category category);
    List<CategoryDTO> toCategoryDtos(List<Category> categories);

    Category toCategory(CategoryDTO categoryDTO);
    List<Category> toCategories(List<CategoryDTO> categoryDTOS);
}
