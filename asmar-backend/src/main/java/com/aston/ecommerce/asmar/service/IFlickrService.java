package com.aston.ecommerce.asmar.service;

import java.io.InputStream;

public interface IFlickrService {

    String savePhoto(InputStream inputStream, String fileName) throws Exception;
}
