package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.OrderDetailsDTO;
import com.aston.ecommerce.asmar.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDetailsDTO toOrderDto(Order order);
    List<OrderDetailsDTO> toOrderDtos(List<Order> orders);

    Order toOrder(OrderDetailsDTO OrderDTO);
    List<Order> toImages(List<OrderDetailsDTO> OrderDTOS);
}
