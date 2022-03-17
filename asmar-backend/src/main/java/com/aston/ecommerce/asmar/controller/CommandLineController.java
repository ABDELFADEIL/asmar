
package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.dto.ProductDetailDTO;
import com.aston.ecommerce.asmar.dto.ProductToCartDTO;

import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;
import com.aston.ecommerce.asmar.service.CommandLineService;
import com.aston.ecommerce.asmar.service.ProductService;
import com.aston.ecommerce.asmar.service.UserService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/api/commandLine")
public class CommandLineController {


    private final CommandLineService commandLineService;

    private final ProductService productService;


    public CommandLineController(CommandLineService commandLineService, UserService userService, ProductService productService) {
        this.commandLineService = commandLineService;
        this.productService = productService;
    }

    /*get commands of current user */
    @GetMapping("/commands")
    @ApiOperation(value = "Get commands of current user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return commands of current user"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "user not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<CommandLineDTO>> getCommandLineList(@RequestParam(name = "userId") Long userId) {
        List<CommandLineDTO> commandLineDTOList = commandLineService.getCommandLineListByUserId(userId);
        if (commandLineDTOList == null) {
            return new ResponseEntity<>(commandLineDTOList, HttpStatus.NOT_FOUND);

        }
        return ResponseEntity.ok(commandLineDTOList);
    }

    @PostMapping("/add")
    public ResponseEntity<CommandLineDTO> addProductToCart(
           @RequestBody ProductToCartDTO productToCartDTO
    ) {

        CommandLineDTO commandLineDTO = commandLineService.addProductToCart(productToCartDTO);

        return new ResponseEntity<>(commandLineDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CommandLineDTO> updateCommandLine(
            @Valid @RequestBody  CommandLineDTO commandLineDTO,
           /* @RequestParam("id")  Long id,
            @RequestParam ("quantity") int quantity,*/
            @AuthenticationPrincipal User user
    ){
        Product product = productService.findById(commandLineDTO.getProduct().getId());

        commandLineService.updateCommandLine(commandLineDTO,user,product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{Id}")
    public ResponseEntity<Void> deleteCommandLine(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        commandLineService.deleteCommandLine(id, user);
        return ResponseEntity.noContent().build();

    }
}



