package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.model.Image;

import java.util.List;

public interface ImagesService {
    Image findImageByImageId(int imageId);
    List<Image> findImages(int count);
    long getImagesCount();
}
