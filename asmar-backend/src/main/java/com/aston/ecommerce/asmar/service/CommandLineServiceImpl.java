package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.CommandLineRepository;
import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dao.UserRepository;
import com.aston.ecommerce.asmar.dto.CommandLineDTO;

import com.aston.ecommerce.asmar.dto.ProductToCartDTO;
import com.aston.ecommerce.asmar.dto.mapper.CommandLineMapper;
import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


@Service
public class CommandLineServiceImpl implements CommandLineService {


    @Autowired
    private CommandLineMapper commandLineMapper;
    @Autowired
    private CommandLineRepository commandLineRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommandLineDTO> getCommandLineListByUserId(Long userId) {
        List<CommandLine> commandLineList = commandLineRepository.findByUserAndOrderIsNull(userId);
        return commandLineMapper.toCommandLineDtos(commandLineList);
    }

    @Override
    public CommandLineDTO addProductToCart(ProductToCartDTO productToCartDTO) {
        CommandLine commandLine = commandLineRepository.findByProductAndOrderIsNull(productToCartDTO.getProductId());
        if (commandLine == null) {
            Product product = productRepository.getById(productToCartDTO.getProductId());
            User user = userRepository.getById(productToCartDTO.getUserId());

            CommandLine command = new CommandLine();
            BigDecimal price = product.getPrice().multiply(BigDecimal.valueOf(productToCartDTO.getQuantity()));
            command.setPrice(price);
            command.setQuantity(productToCartDTO.getQuantity());
            command.setProduct(product);
            command.setUser(user);
            command.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            command = commandLineRepository.save(command);
            return commandLineMapper.toCommandLineDto(command);
        } else {
            int quantity = commandLine.getQuantity() + productToCartDTO.getQuantity();
            BigDecimal price = commandLine.getProduct().getPrice().multiply(BigDecimal.valueOf(quantity));
            commandLine.setPrice(price);
           commandLine.setQuantity(quantity);
           commandLine = commandLineRepository.save(commandLine);
            return commandLineMapper.toCommandLineDto(commandLine);
        }

    }

    @Override
     public CommandLineDTO updateCommandLine( CommandLineDTO commandLineDTO,User user,Product product) {

        CommandLine commandLine = commandLineRepository.getById(commandLineDTO.getId());
        commandLine.setQuantity(commandLineDTO.getQuantity());
        commandLine.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        commandLine = commandLineRepository.save(commandLine);
        return commandLineMapper.toCommandLineDto(commandLine);
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