
package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dao.CommandLineRepository;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.service.CommandLineService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commandLine")
public class CommandLineController {


    private final CommandLineService commandLineService;

    private final CommandLineRepository commandLineRepository;

    public CommandLineController(CommandLineService commandLineService, CommandLineRepository commandLineRepository) {
        this.commandLineService = commandLineService;
        this.commandLineRepository = commandLineRepository;
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

}
