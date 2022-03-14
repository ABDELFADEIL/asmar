package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dto.AddressDTO;
import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.dto.UserForm;
import com.aston.ecommerce.asmar.service.AddressService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @PostMapping("/add")
    @ApiOperation(value = "Add new address")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New address created"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<AddressDTO> addUser(@RequestBody AddressDTO addressDTO){

        AddressDTO address = addressService.addAddress(addressDTO);
        if (address == null){
            return new ResponseEntity<>(address, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }
}
