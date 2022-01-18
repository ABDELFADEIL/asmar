package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.AddressRepository;
import com.aston.ecommerce.asmar.dao.UserRepository;
import com.aston.ecommerce.asmar.dto.AddressDTO;
import com.aston.ecommerce.asmar.dto.mapper.AddressMapper;
import com.aston.ecommerce.asmar.entity.Address;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressMapper addressMapper;


    @Override
    public AddressDTO addAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toAddress(addressDTO);
        User user = userRepository.getById(addressDTO.getUser().getId());
        address.setUser(user);
        address = addressRepository.save(address);
        return addressMapper.toAddressDto(address);
    }
}
