
package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.CommandLineDTO;

import java.util.List;


public interface CommandLineService {

    CommandLineDTO addCommandLineByUserId(Long userId);
    List<CommandLineDTO> getCommandLineListByUserId(Long userId);
    String deleteCommandLine(String id);

}

