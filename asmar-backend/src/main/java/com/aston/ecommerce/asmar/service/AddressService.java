package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.AddressDTO;
import java.util.List;

public interface AddressService {

    AddressDTO addAddress(AddressDTO addressDTO);
    List<AddressDTO> getAddressesByUserId(Integer userId);
    AddressDTO updateAddressActiveAndType(Integer addressId, String addressType) throws IllegalAccessException;
}
