package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.model.Image;

import java.util.List;

public interface ImagesService {
    Image findImageByImageId(long imageId);
    List<Image> findImages(int pageSize, int page);
    long getImagesCount();
}
