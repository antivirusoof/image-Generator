package com.zeta.random.image.repository;

import com.zeta.random.image.Model.ImageDetail;

import java.util.List;

public interface ImageRepository {
    ImageDetail saveImage(ImageDetail imageDetail);

    ImageDetail getImage(String Id);

    List<ImageDetail> getAll();

}
