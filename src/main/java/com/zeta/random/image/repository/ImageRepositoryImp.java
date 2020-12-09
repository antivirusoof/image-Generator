package com.zeta.random.image.repository;

import com.zeta.random.image.Model.ImageDetail;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ImageRepositoryImp implements ImageRepository {
    public static final HashMap<String, ImageDetail> tempDb = new HashMap<>();

    @Override
    public ImageDetail saveImage(ImageDetail imageDetail) {
        tempDb.put(imageDetail.getId(), imageDetail);
        return imageDetail;

    }

    @Override
    public ImageDetail getImage(String id) {
        ImageDetail imageDetail = tempDb.get(id);
        return imageDetail;
    }

    @Override
    public List<ImageDetail> getAll() {
        return tempDb.values().stream().collect(Collectors.toList());
    }
}
