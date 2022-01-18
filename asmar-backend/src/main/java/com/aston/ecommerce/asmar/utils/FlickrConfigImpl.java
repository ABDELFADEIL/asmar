package com.aston.ecommerce.asmar.utils;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.io.InputStream;

@Service
@Transactional
public class FlickrConfigImpl implements IFlickrCofig {

    private static final Logger logger = LoggerFactory.getLogger(FlickrConfigImpl.class);



    // private final String sharedSecret;
    @Autowired
    public  Flickr flickr;


    private UploadMetaData uploadeMetaData =new UploadMetaData();
    private String apiKey="2d89f8efd8dab32024ceedd381e29e08";
    private String sharedSecret="928bc2bcf01e0b08";



    @Override
    public void connect() {
        flickr = new Flickr(apiKey, sharedSecret, new REST());
        Auth auth = new Auth();
        auth.setPermission(Permission.READ);
        auth.setToken("72157711759371071-4ccecbb17dc313cf");
        auth.setTokenSecret("678de353717b65cb");
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
    }

    @Bean
    public Flickr flickr(){
        return new Flickr(apiKey, sharedSecret, new REST());
    }

    @Override
    public String savePhoto(InputStream inputStream, String fileName) throws Exception{
        connect();
        uploadeMetaData.setTitle(fileName);
        String photoId = flickr.getUploader().upload(inputStream, uploadeMetaData);
        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }

    public void auth() {
        flickr = new Flickr(apiKey, sharedSecret, new REST());
        AuthInterface authInterface = flickr.getAuthInterface();
        OAuth1RequestToken token = authInterface.getRequestToken();
        System.out.println("token: " + token);
        String url= authInterface.getAuthorizationUrl(token, Permission.DELETE);
        System.out.println("flow this url ");
        System.out.println(url);

        String tokenKey= JOptionPane.showInputDialog(null);
        OAuth1Token accessToken = authInterface.getAccessToken(token, tokenKey);
        System.out.println("Autentication success");
        Auth auth = null;
        try {
            auth = authInterface.checkToken(token);
        } catch (FlickrException e) {
            e.printStackTrace();
        }
        // This token can be used until the user revokes it.
        System.out.println("Token: " + accessToken.getToken());
        System.out.println("Secret: " + accessToken.getTokenSecret());
        System.out.println("nsid: " + auth.getUser().getId());
        System.out.println("Realname: " + auth.getUser().getRealName());
        System.out.println("Username: " + auth.getUser().getUsername());
        System.out.println("Permission: " + auth.getPermission().getType());
    }

}