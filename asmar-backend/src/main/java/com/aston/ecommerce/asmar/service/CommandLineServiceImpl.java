package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.CommandLineRepository;
import com.aston.ecommerce.asmar.dto.CommandLineDTO;

import com.aston.ecommerce.asmar.dto.addProductToCartDTO;
import com.aston.ecommerce.asmar.dto.mapper.CommandLineMapper;
import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.Order;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class CommandLineServiceImpl implements CommandLineService {


    @Autowired
    private CommandLineMapper commandLineMapper;
    @Autowired
    private CommandLineRepository commandLineRepository;

    @Override
    public List<CommandLineDTO> getCommandLineListByUserId(Long userId) {
        List<CommandLine> commandLineList = commandLineRepository.findByUserAndOrderIsNull(userId);
        return commandLineMapper.toCommandLineDtos(commandLineList);
    }

    @Override
    public CommandLineDTO addProductToCart(addProductToCartDTO addProductToCartDTO) {
        CommandLine command = new CommandLine();
        command.setQuantity(addProductToCartDTO.getQuantity());
        command.setProduct(addProductToCartDTO.getProduct());
        command.setUser(addProductToCartDTO.getUser());
        Order ord = commandLineRepository.findOrderByIdOrderByDesc();

        command.setOrder(ord);
        return commandLineMapper.toCommandLineDto(command);
    }

    @Override
     public void updateCommandLine( CommandLineDTO commandLineDTO,User user,Product product) {

        CommandLine commandLine = commandLineRepository.getById(commandLineDTO.getId());
        commandLine.setQuantity(commandLineDTO.getQuantity());
        commandLine.setCreatedDate(new Date());
        commandLineRepository.save(commandLine);
    }

    @Override
    public CommandLine findById(Long id) {
        return commandLineRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCommandLine(Long id, User user) {
        CommandLine commandLine = commandLineRepository.getById(id);
        if (commandLine.getUser().getId().equals(user.getId())) {
            commandLineRepository.deleteById(commandLine.getId());
        }
    }

    @Override
    public CommandLineDTO save(CommandLine commandLine) {
        return commandLineMapper.toCommandLineDto(commandLineRepository.save(commandLine));
    }

    @Override
    public List<CommandLineDTO> findByOrder(Long orderId) {
        return commandLineMapper.toCommandLineDtos(commandLineRepository.findByOrder(orderId));
    }



}