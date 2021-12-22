package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;



}
