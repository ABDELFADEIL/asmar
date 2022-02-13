package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.CommandLineRepository;
import com.aston.ecommerce.asmar.dto.CommandLineDTO;

import com.aston.ecommerce.asmar.dto.mapper.CommandLineMapper;
import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
     public CommandLineDTO updateCommandLine(Long id, CommandLine commandLine,User user) {

        BigDecimal bigDecimal = new BigDecimal(commandLine.getProduct().getPrice()).multiply(new BigDecimal(commandLine.getQuantity()));
        commandLine.getSubTotal(bigDecimal);
        commandLineRepository.save(commandLine);
        return commandLineMapper.toCommandLineDto(commandLine);

    }

    @Override
    public CommandLineDTO  addProductToCart(User user, Product product, int quantity) {

        List<CommandLine> commandLineList = commandLineRepository.findByUserAndOrderIsNull(user.getId());

        for (CommandLine commandLine : commandLineList) {
            if (product.getId() == commandLine.getProduct().getId()) {
                commandLine.setProduct(product);
                commandLine.setQuantity(commandLine.getQuantity() + quantity);
                commandLine.setSubTotal(new BigDecimal(product.getPrice()).multiply(new BigDecimal(quantity)));
                commandLineRepository.save(commandLine);

            }
            commandLine = new CommandLine();
            commandLine.setProduct(product);
            commandLine.setQuantity(quantity);
            commandLine.getSubTotal(new BigDecimal(product.getPrice()).multiply(new BigDecimal(quantity)));
            commandLine = commandLineRepository.save(commandLine);
            return commandLineMapper.toCommandLineDto(commandLine);
        }
        return (CommandLineDTO) commandLineList;
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