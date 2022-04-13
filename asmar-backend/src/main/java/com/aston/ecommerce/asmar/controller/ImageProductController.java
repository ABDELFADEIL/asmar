package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dto.ImageSaveDTO;
import com.aston.ecommerce.asmar.service.IFlickrService;
import com.aston.ecommerce.asmar.service.ImageProductService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageProductController {

   private IFlickrService flickrService;
   private ImageProductService imageProductService;

    public ImageProductController(
            IFlickrService flickrService,
            ImageProductService imageProductService
                                 ) {
        this.flickrService = flickrService;
        this.imageProductService = imageProductService;
    }

    @PostMapping("/save-image")
    public String saveProductImage(@ModelAttribute ImageSaveDTO imageSaveDTO) throws Exception {
        System.out.println("imageSaveDTO");
        System.out.println(imageSaveDTO);
        return imageProductService.saveProductImage(imageSaveDTO);
    }
}
