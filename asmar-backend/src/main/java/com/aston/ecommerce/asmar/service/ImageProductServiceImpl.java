package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.ImageRepository;
import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ImageSaveDTO;
import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.entity.Image;
import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ImageProductServiceImpl implements ImageProductService{


    private final IFlickrService flickrService;
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    public ImageProductServiceImpl(
                                   final IFlickrService flickrService,
                                   final ProductRepository productRepository,
                                   final ImageRepository imageRepository
    ) {
        this.flickrService = flickrService;
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public String saveProductImage(ImageSaveDTO imageSaveDTO) throws Exception {
        Product product = productRepository.findById(imageSaveDTO.getId()).get();
        System.out.println("product : ");
        System.out.println(product);
        System.out.println("add image : ");
        InputStream inputStream = imageSaveDTO.getFile().getInputStream();
        String nameFile= imageSaveDTO.getFile().getName();
        String urlImage = flickrService.savePhoto(inputStream, nameFile);
        Image image = new Image();
        image.setProduct(product);
        image.setUrl(urlImage);
        image.setPrincipal(imageSaveDTO.isPrincipal());
        image = imageRepository.save(image);
        return image.getUrl();
    }
}
