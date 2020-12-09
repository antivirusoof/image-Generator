package com.zeta.random.image.restclient;

import com.zeta.random.image.exception.ImageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoremRestClient {
    public static final String BASE_URL = "https://picsum.photos/200/300";

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<byte[]> getImage() throws ImageException {
        ResponseEntity<byte[]> entity = restTemplate.getForEntity(BASE_URL, byte[].class);
        return entity;
    }

    public ResponseEntity<byte[]> getImage(String url) throws ImageException {
        ResponseEntity<byte[]> entity = restTemplate.getForEntity(url, byte[].class);
        return entity;
    }
}
