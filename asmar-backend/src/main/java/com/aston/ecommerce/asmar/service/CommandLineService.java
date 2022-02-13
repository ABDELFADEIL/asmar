
package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;


import java.util.List;


public interface CommandLineService {


    List<CommandLineDTO> getCommandLineListByUserId(Long userId);
    CommandLineDTO addProductToCart(User user, Product product, int quantity);
    CommandLine findById(Long id);
    CommandLineDTO updateCommandLine(Long id, CommandLine commandLine, User user);
    void deleteCommandLine(Long id, User user);
    CommandLineDTO save(CommandLine commandLine);
    List<CommandLineDTO> findByOrder(Long orderId);
}

