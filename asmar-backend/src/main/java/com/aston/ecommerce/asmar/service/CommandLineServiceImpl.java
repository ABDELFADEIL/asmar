package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.CommandLineRepository;
import com.aston.ecommerce.asmar.dto.CommandLineDTO;

import com.aston.ecommerce.asmar.dto.mapper.CommandLineMapper;
import com.aston.ecommerce.asmar.entity.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandLineServiceImpl implements CommandLineService{


    @Autowired
    private CommandLineMapper commandLineMapper;
    @Autowired
    private CommandLineRepository commandLineRepository;


    @Override
    public CommandLineDTO addCommandLineByUserId(Long userId) {
        return null;
    }

    @Override
    public List<CommandLineDTO> getCommandLineListByUserId(Long userId) {
        List<CommandLine> commandLineList = commandLineRepository.findByUserAndOrderIsNull(userId);
        return commandLineMapper.toCommandLineDtos(commandLineList);
    }

    @Override
    public String deleteCommandLine(String id) {
        return null;
    }
}

