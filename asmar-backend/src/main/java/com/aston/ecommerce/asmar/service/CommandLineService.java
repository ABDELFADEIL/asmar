
package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.dto.ProductToCartDTO;
import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;


import java.util.List;


public interface CommandLineService {


    List<CommandLineDTO> getCommandLineListByUserId(Long userId);
    CommandLine findById(Long id);
    CommandLineDTO updateCommandLine(CommandLineDTO commandLineDTO, User user,Product product);
    void deleteCommandLine(Long id, UserDTO user);
    CommandLineDTO save(CommandLine commandLine);
    List<CommandLineDTO> findByOrder(Long orderId);
    CommandLineDTO addProductToCart(ProductToCartDTO addProductToCartDTO);
    CommandLineDTO updateCommandLineQuantity(Long id, int quantity, UserDTO user);
}

