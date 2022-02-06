package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.CartDTO;
import com.aston.ecommerce.asmar.entity.Cart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartDTO toCartDto(Cart cart);
    List<CartDTO> toCartDtos(List<Cart> carts);

    Cart toCart(CartDTO CartDTO);
    List<Cart> toCarts(List<CartDTO> CartDTOS);


}
