package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.OrderDetailsDTO;

public interface OrderService {
    public OrderDetailsDTO createOrder(OrderDetailsDTO orderDto);
}
