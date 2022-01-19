package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.AddressDTO;
import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.UserForm;
import com.aston.ecommerce.asmar.entity.AbstractEntity;
import com.aston.ecommerce.asmar.entity.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = { UserMapper.class})
public interface AddressMapper {


    AddressDTO toAddressDto(Address address);
    @InheritInverseConfiguration
    List<AddressDTO> toAddressDtos(List<Address> addresses);
    Address toAddress(AddressDTO addressDTO);
    List<Address> toAddresses(List<AddressDTO> addressDTOS);
    AddressDTO toAddressDto(UserForm userForm);
}
