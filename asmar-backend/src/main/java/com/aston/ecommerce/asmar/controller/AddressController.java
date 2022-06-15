package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dto.AddressDTO;
import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.entity.User;
import com.aston.ecommerce.asmar.service.AddressService;
import com.aston.ecommerce.asmar.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;
    private final IUserService userService;
    public AddressController(AddressService addressService, IUserService userService) {
        this.addressService = addressService;
        this.userService = userService;
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add new address")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New address created"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<AddressDTO> addUser(@RequestBody AddressDTO addressDTO){
        System.out.println("addressDTO ****************************************");
        System.out.println(addressDTO);
        AddressDTO address = addressService.addAddress(addressDTO);
        if (address == null){
            return new ResponseEntity<>(address, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @GetMapping("/user-addresses")
    @ApiOperation(value = "get list of user's addresses")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<AddressDTO>> getListAddresses(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = userService.getCurrentUser(auth.getPrincipal().toString());
        List<AddressDTO> addresses = addressService.getAddressesByUserId(userDTO.getId());
        if (addresses.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    // '/api/addresses/update-type/
    @PutMapping("/update-active/{addressId}")
    @ApiOperation(value = "update active address for delivery or billing")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<AddressDTO> updateAddressActiveAndType(@RequestParam String addressType, @PathVariable Integer addressId) throws IllegalAccessException {
        AddressDTO address = addressService.updateAddressActiveAndType(addressId, addressType);
        if (address == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
