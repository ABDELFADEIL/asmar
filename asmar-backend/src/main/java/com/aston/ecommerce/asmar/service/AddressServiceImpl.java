package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.AddressRepository;
import com.aston.ecommerce.asmar.dao.UserRepository;
import com.aston.ecommerce.asmar.dto.AddressDTO;
import com.aston.ecommerce.asmar.dto.mapper.AddressMapper;
import com.aston.ecommerce.asmar.entity.Address;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional(rollbackFor = Exception.class)
public class AddressServiceImpl implements AddressService{


    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(final AddressRepository addressRepository,
                              final UserRepository userRepository,
                              final AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDTO addAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toAddress(addressDTO);
        User user = userRepository.getById(addressDTO.getUserId());
        address.setUser(user);
        if (addressDTO.getFullName() == null){
            addressDTO.setFullName(user.getFirstName() + " " + user.getLastName());
        }
        address = addressRepository.save(address);
        return addressMapper.toAddressDto(address);
    }

    @Override
    public List<AddressDTO> getAddressesByUserId(Long userId) {
        List<Address> addressList = addressRepository.findAddressesByUserId(userId);
        return addressMapper.toAddressDtos(addressList);
    }

    @Override
    public AddressDTO updateAddressActiveAndType(Long addressId, String addressType) throws IllegalAccessException {
        if (addressId == null){
            throw new IllegalAccessException("No address id");
        }
        Address address = addressRepository.getById(addressId);
        if (address == null){
            throw new IllegalAccessException("No address found with id " + addressId);
        }
        System.out.println("user id = " + address.getUser().getId());
        List<Address> addressList = addressRepository.findAddressesByUserId(address.getUser().getId());
        //System.out.println(" size of addresses list: " + addressList.size());
        //System.out.println("Objects.equals(addressType, delivery): " + Objects.equals(addressType, "delivery"));
        //System.out.println("Objects.equals(addressType, billing): " + Objects.equals(addressType, "billing"));

        addressList.forEach(address1 -> {
            if (    address1.isDelivery() &&
                    Objects.equals(addressType, "delivery") &&
                    address.getId() != address1.getId()
               ){
                 address1.setDelivery(false);
                 addressRepository.save(address1);
            }else if (
                    address1.isBilling() &&
                            Objects.equals(addressType, "billing") &&
                    address.getId() != address1.getId()
                    ){
                address1.setBilling(false);
                addressRepository.save(address1);
            }
        }
        );
        if (Objects.equals(addressType, "delivery")){
            address.setDelivery(true);
        }else if (Objects.equals(addressType, "billing")){
            address.setBilling(true);
        }
        addressRepository.save(address);
        return addressMapper.toAddressDto(address);
    }
}
