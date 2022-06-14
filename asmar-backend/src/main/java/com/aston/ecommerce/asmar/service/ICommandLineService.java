
package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;
import com.aston.ecommerce.asmar.dto.ProductToCartDTO;
import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;


import java.util.List;


public interface ICommandLineService {

    List<CommandLineDTO> getCommandLineListByUserId(Integer userId);
    CommandLine findById(Integer id);
    CommandLineDTO updateCommandLine(CommandLineDTO commandLineDTO, User user,Product product);
    void deleteCommandLine(Integer id, UserDTO user);
    CommandLineDTO save(CommandLine commandLine);
    List<CommandLineDTO> findByOrder(Integer orderId);
    CommandLineDTO addProductToCart(ProductToCartDTO addProductToCartDTO);
    CommandLineDTO updateCommandLineQuantity(Integer id, int quantity, UserDTO user);
}

