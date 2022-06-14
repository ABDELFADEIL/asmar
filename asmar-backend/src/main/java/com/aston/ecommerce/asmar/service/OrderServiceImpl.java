package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.OrderRepository;
import com.aston.ecommerce.asmar.dto.OrderDetailsDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService{


    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderDetailsDTO createOrder(OrderDetailsDTO orderDto) {
        return null;
    }
}
