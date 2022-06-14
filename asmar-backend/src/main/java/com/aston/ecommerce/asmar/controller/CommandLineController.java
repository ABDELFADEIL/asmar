
package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.dto.ProductToCartDTO;
import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;
import com.aston.ecommerce.asmar.service.ICommandLineService;
import com.aston.ecommerce.asmar.service.IProductService;
import com.aston.ecommerce.asmar.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/commandLine")
public class CommandLineController {

    private final ICommandLineService commandLineService;
    private final IProductService productService;
    private final IUserService userService;
    public CommandLineController(ICommandLineService commandLineService, IUserService userService,
                                 IProductService productService, IUserService userService1) {
        this.commandLineService = commandLineService;
        this.productService = productService;
        this.userService = userService;
    }
    /*get commands of current user */
    @GetMapping("/shopping-cart")
    @ApiOperation(value = "Get commandLines (shopping card) of current user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return commands of current user"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "user not found"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<CommandLineDTO>> getCommandLineList(@RequestParam(name = "userId") Integer userId) {
        List<CommandLineDTO> commandLineDTOList = commandLineService.getCommandLineListByUserId(userId);
        if (commandLineDTOList == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteCommandLine(@PathVariable("id") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDTO user = userService.getCurrentUser(auth.getPrincipal().toString());
        commandLineService.deleteCommandLine(id, user);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/update-quantity/{id}")
    public ResponseEntity<CommandLineDTO> updateCommandLineQuantity(
            @PathVariable(name = "id", required = true) Integer id,
            @RequestParam(name = "quantity", required = true) int quantity) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDTO user = userService.getCurrentUser(auth.getPrincipal().toString());
        CommandLineDTO commandLineDTO =
                commandLineService.updateCommandLineQuantity(id, quantity, user);
        return ResponseEntity.ok(commandLineDTO);

    }
}



