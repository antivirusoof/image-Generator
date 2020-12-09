package com.zeta.random.image.serivce.impl;

import com.zeta.random.image.Model.ImageDetail;
import com.zeta.random.image.repository.ImageRepository;
import com.zeta.random.image.restclient.LoremRestClient;
import com.zeta.random.image.serivce.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ImageServiceImp implements ImageService {
    public static final String URL = "https://picsum.photos/id/{id}/200/300";
    public static final String KEYWORD = "Picsum-Id";
    @Autowired
    LoremRestClient loremRestClient;

    @Autowired
    ImageRepository imageRepository;

    public byte[] getRamdonImage() {
        ResponseEntity<byte[]> responseEntity = loremRestClient.getImage();
        return responseEntity.getBody();

    }

    public byte[] getImageById(String id) {
        ImageDetail imageDetail = imageRepository.getImage(id);
        if (imageDetail != null)
            return loremRestClient.getImage(imageDetail.getImageUrl()).getBody();
        ResponseEntity<byte[]> responseEntity = loremRestClient.getImage();
        String pcmsId = responseEntity.getHeaders().get(KEYWORD).get(0);
        ImageDetail imageDetail1 = generateImageDetails(id, pcmsId);
        return responseEntity.getBody();
    }

    public List<ImageDetail> getAllImages() {
        return imageRepository.getAll();
    }

    private String formUrl(String id) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(URL)
                .build();
        uriComponents = uriComponents.expand(Collections.singletonMap("id", id));
        return uriComponents.toString();

    }

    private ImageDetail generateImageDetails(String id, String pcismId) {
        ImageDetail imageDetail =new ImageDetail();
        imageDetail.setImageUrl(formUrl(pcismId));
        imageDetail.setId(id);
        imageDetail.setCreatedDate(new Date());
        imageRepository.saveImage(imageDetail);
        return imageDetail;
    }
}
