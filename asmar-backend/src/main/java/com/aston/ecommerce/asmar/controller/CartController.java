package com.aston.ecommerce.asmar.controller;


import com.aston.ecommerce.asmar.dao.CartRepository;
import com.aston.ecommerce.asmar.service.CartService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    private final CartRepository cartRepository;

    public CartController(CartService cartService, CartRepository cartRepository) {
        this.cartService = cartService;
        this.cartRepository = cartRepository;
    }

/*    @PostMapping
    public ResponseEntity<CartDTO> addCart(
            @ApiParam(value = "owner of the cart", required = true) @Valid @RequestBody UserDTO userDTO,
            @ApiParam(value = "user ID") @RequestParam(required = false, defaultValue = "") String userId) {


    }*/


}
