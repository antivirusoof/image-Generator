package com.zeta.random.image.serivce;

import com.zeta.random.image.Model.ImageDetail;

import java.util.List;

public interface ImageService {
    byte[] getRamdonImage();
    byte[] getImageById(String id);
    List<ImageDetail> getAllImages();
}
