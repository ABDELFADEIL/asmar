package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.ImageDTO;
import com.aston.ecommerce.asmar.entity.Image;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageDTO toImageDto(Image image);
    List<ImageDTO> toImageDtos(List<Image> images);

    Image toImage(ImageDTO imageDTO);
    List<Image> toImages(List<ImageDTO> imageDTOS);
}
