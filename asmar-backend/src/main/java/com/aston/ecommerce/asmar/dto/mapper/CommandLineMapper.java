package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.AddressDTO;
import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.entity.Address;
import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommandLineMapper {
    public static final CommandLineMapper INSTANCE = Mappers.getMapper(CommandLineMapper.class);
    CommandLineDTO toCommandLineDto(CommandLine commandLine);
    List<CommandLineDTO> toCommandLineDtos(List<CommandLine> commandLines);

    CommandLine toCommandLine(CommandLineDTO commandLineDTO);
    List<CommandLine> toAddresses(List<CommandLineDTO> commandLineDTOS);
}
