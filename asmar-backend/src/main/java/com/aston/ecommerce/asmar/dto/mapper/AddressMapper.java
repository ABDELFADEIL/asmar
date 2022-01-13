package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.AddressDTO;
import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.entity.Address;
import com.aston.ecommerce.asmar.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    public static final AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    AddressDTO toAddressDto(Address address);
    List<ProductDTO> toAddressDtos(List<Address> addresses);

    Address toAddress(AddressDTO addressDTO);
    List<Address> toAddresses(List<AddressDTO> addressDTOS);
}
