package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.dto.ImageDTO;
import com.aston.ecommerce.asmar.entity.Address;
import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    public static final ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);
    ImageDTO toImageDto(Image image);
    List<ImageDTO> toImageDtos(List<Image> images);

    Image toCommandLine(CommandLineDTO commandLineDTO);
    List<Image> toImages(List<ImageDTO> imageDTOS);
}
