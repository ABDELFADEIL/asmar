
package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dao.CommandLineRepository;

import com.aston.ecommerce.asmar.service.CommandLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commandLine")
public class CommandLineController {


    private final CommandLineService commandLineService;

    private final CommandLineRepository commandLineRepository;

    public CommandLineController(CommandLineService commandLineService, CommandLineRepository commandLineRepository) {
        this.commandLineService = commandLineService;
        this.commandLineRepository = commandLineRepository;
    }

}
