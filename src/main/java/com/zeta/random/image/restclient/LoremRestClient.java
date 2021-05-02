package com.zeta.random.image.restclient;

import com.zeta.random.image.exception.ImageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;

@Component
public class LoremRestClient {
    //public static final String BASE_URL = "https://picsum.photos/200/300";
static int count = 0;
    @Autowired
    RestTemplate restTemplate;

   @Retryable(value = {UnknownHostException.class},
           maxAttempts = 3,
            backoff = @Backoff(10000))
    public ResponseEntity<byte[]> getImage() throws ImageException {
       int count  = 0;
       System.out.println("retry ="+count);
       count ++;

       String BASE_URL="https://picsume.photos/200/300";
       if(count >2)
           BASE_URL = "https://picsum.photos/200/300";;
        ResponseEntity<byte[]> entity = restTemplate.getForEntity(BASE_URL, byte[].class);
        return entity;
    }

    public ResponseEntity<byte[]> getImage(String url) throws ImageException {
        ResponseEntity<byte[]> entity = restTemplate.getForEntity(url, byte[].class);
        return entity;
    }
}
