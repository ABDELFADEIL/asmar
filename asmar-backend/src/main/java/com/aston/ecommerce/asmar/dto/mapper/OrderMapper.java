package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.dto.ImageDTO;
import com.aston.ecommerce.asmar.dto.OrderDTO;
import com.aston.ecommerce.asmar.entity.Image;
import com.aston.ecommerce.asmar.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toOrderDto(Order order);
    List<OrderDTO> toOrderDtos(List<Order> orders);

    Order toOrder(OrderDTO OrderDTO);
    List<Order> toImages(List<OrderDTO> OrderDTOS);
}
