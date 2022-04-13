package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.CategoryDTO;
import com.aston.ecommerce.asmar.entity.Category;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toCategoryDto(Category category);
    List<CategoryDTO> toCategoryDtos(List<Category> categories);

    Category toCategory(CategoryDTO categoryDTO);
    List<Category> toCategories(List<CategoryDTO> categoryDTOS);
}
