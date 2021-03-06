package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.config.IFlickrCofig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

@Service
@Transactional(rollbackFor = Exception.class)
public class FlickrImplService implements IFlickrService{

    @Autowired
    private IFlickrCofig filckrIFlickrCofig;

    @Override
    public String savePhoto(InputStream inputStream, String fileName) throws Exception {
        return filckrIFlickrCofig.savePhoto(inputStream, fileName);
    }
}
