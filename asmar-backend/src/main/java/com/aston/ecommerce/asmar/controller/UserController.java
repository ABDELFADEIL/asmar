package com.aston.ecommerce.asmar.controller;


import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.dto.UserForm;
import com.aston.ecommerce.asmar.dto.UserMobileDTO;
import com.aston.ecommerce.asmar.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New User created"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<UserDTO> addUser(@RequestBody UserForm userForm){

        UserDTO userDto = userService.addUser(userForm);
        if (userDto == null){
            return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
    @PostMapping("/new")
    @ApiOperation(value = "Add new user mobile app")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New User created"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<UserDTO> addUserMobile(@RequestBody UserMobileDTO userMobileDTO){

        UserDTO userDto = userService.addUser(userMobileDTO);
        if (userDto == null){
            return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    /*get all users */
    @GetMapping("/all")
    @ApiOperation(value = "Get List of all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return the list of all users"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "products not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOList = userService.findAll();
        if (userDTOList.isEmpty()) {
            return new ResponseEntity<>(userDTOList, HttpStatus.NOT_FOUND);

        }
        return ResponseEntity.ok(userDTOList);
    }

    /*get current user */
    @GetMapping("/user")
    @ApiOperation(value = "Get current user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return current user"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "user not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<UserDTO> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = userService.getCurrentUser(auth.getPrincipal().toString());
        if (userDTO == null) {
            return new ResponseEntity<>(userDTO, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userDTO);
    }

}
