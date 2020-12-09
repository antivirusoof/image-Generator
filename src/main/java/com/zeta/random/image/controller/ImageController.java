package com.zeta.random.image.controller;

import com.zeta.random.image.serivce.impl.ImageServiceImp;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/v1")
@ManagedResource
@Slf4j
public class ImageController {
    @Autowired
    ImageServiceImp imageServiceImp;

    @RequestMapping(value = "/image", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    @ManagedOperation
    public ResponseEntity<byte[]> getImage() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageServiceImp.getRamdonImage());
    }

    @RequestMapping(value = "/images", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<?>> getAllImage() {
        return ResponseEntity
                .ok()
                .body(imageServiceImp.getAllImages());
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImageById(@PathVariable @NonNull String id) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageServiceImp.getImageById(id));
    }


}
