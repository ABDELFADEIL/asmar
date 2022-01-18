package com.aston.ecommerce.asmar.utils;

import java.io.InputStream;

public interface IFlickrCofig {

    public String savePhoto(InputStream inputStream, String fileName) throws Exception;
    public void connect();
    public void auth();
}
