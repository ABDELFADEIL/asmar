package com.aston.ecommerce.asmar.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aston.ecommerce.asmar.config.FlickrConfigImpl;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.Transport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FlickrConfigImpl.class})
@ExtendWith(SpringExtension.class)
class FlickrConfigImplTest {

    @MockBean
    private Flickr flickr;

    @Autowired
    private FlickrConfigImpl flickrConfigImpl;

    @Test
    void testConnect() {
        this.flickrConfigImpl.connect();
        assertEquals("2d89f8efd8dab32024ceedd381e29e08", this.flickrConfigImpl.getFlickr().getApiKey());
    }

    @Test
    void testFlickr() {
        Flickr actualFlickrResult = this.flickrConfigImpl.flickr();
        assertEquals("2d89f8efd8dab32024ceedd381e29e08", actualFlickrResult.getApiKey());
        Transport transport = actualFlickrResult.getTransport();
        assertTrue(transport instanceof REST);
        assertEquals("928bc2bcf01e0b08", actualFlickrResult.getSharedSecret());
        assertEquals("api.flickr.com", transport.getHost());
        assertEquals("Og==", ((REST) transport).getProxyCredentials());
        assertEquals("/services/rest/", transport.getPath());
        assertEquals("REST", transport.getTransportType());
        assertEquals(443, transport.getPort());
        assertFalse(((REST) transport).isProxyAuth());
        assertEquals("https", transport.getScheme());
    }
}

