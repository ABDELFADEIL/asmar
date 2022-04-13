package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.entity.CommandLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommandLineMapper {

    @Mapping(source = "commandLine.order.id", target = "orderId")
    CommandLineDTO toCommandLineDto(CommandLine commandLine);
    List<CommandLineDTO> toCommandLineDtos(List<CommandLine> commandLines);
    @Mapping(target = "order.id", source = "orderId")
    CommandLine toCommandLine(CommandLineDTO commandLineDTO);
    List<CommandLine> toCommandLines(List<CommandLineDTO> commandLineDTOS);
}
