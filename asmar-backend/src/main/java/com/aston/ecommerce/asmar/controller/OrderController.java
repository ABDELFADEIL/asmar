package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dto.OrderDetailsDTO;
import com.aston.ecommerce.asmar.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    @ApiOperation(value = "Create new order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New order created"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<OrderDetailsDTO> createOrder(@RequestBody OrderDetailsDTO orderDto){
        OrderDetailsDTO orderDetailsDTO = orderService.createOrder(orderDto);
        if (orderDetailsDTO == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderDetailsDTO, HttpStatus.CREATED);
    }

}
