package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dto.ImageSaveDTO;
import com.aston.ecommerce.asmar.service.IFlickrService;
import com.aston.ecommerce.asmar.service.ImageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/image")
public class ImageProductController {

   @Autowired
   private IFlickrService flickrService;
   @Autowired
   private ImageProductService imageProductService;

    @PostMapping("/save-image")
    public String saveProductImage(@ModelAttribute ImageSaveDTO imageSaveDTO) throws Exception {
        System.out.println("imageSaveDTO");
        System.out.println(imageSaveDTO);
        return imageProductService.saveProductImage(imageSaveDTO);
    }
}
