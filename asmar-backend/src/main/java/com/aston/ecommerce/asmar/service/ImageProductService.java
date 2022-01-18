package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.ImageSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface ImageProductService {


    String saveProductImage(ImageSaveDTO imageSaveDTO) throws Exception;
}
