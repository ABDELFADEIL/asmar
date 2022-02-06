package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.CommandLineRepository;
import com.aston.ecommerce.asmar.dto.CommandLineDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandLineServiceImpl implements CommandLineService{


    @Autowired
    private CommandLineRepository commandLineService;
    @Autowired
    private CommandLineRepository commandLineRepository;


    @Override
    public CommandLineDTO addCommandLineByUserId(Long userId) {
        return null;
    }

    @Override
    public List<CommandLineDTO> getCommandLineListByUserId(Long userId) {
        return null;
    }

    @Override
    public String deleteCommandLine(String id) {
        return null;
    }
}

