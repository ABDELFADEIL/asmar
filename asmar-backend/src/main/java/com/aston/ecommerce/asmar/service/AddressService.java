package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.AddressDTO;
import java.util.List;

public interface AddressService {

    AddressDTO addAddress(AddressDTO addressDTO);
    List<AddressDTO> getAddressesByUserId(Long userId);
    AddressDTO updateAddressActiveAndType(Long addressId, String addressType) throws IllegalAccessException;
}
