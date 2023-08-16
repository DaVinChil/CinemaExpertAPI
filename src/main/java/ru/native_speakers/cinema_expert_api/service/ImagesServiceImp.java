package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Image;
import ru.native_speakers.cinema_expert_api.repository.ImagesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagesServiceImp implements ImagesService {

    private final ImagesRepository imagesRepository;

    @Override
    public Image findImageByImageId(int imageId) throws EntityNotFoundException {
        return imagesRepository.findById(imageId).orElseThrow(() -> new EntityNotFoundException("Image with this id not found"));
    }

    @Override
    public List<Image> findImages(int pageSize, int page) throws EntityNotFoundException {
        List<Image> images = imagesRepository.findAll(PageRequest.of(page, pageSize)).getContent();
        if (images.isEmpty()) {
            throw new EntityNotFoundException("Images not found");
        }
        return images;
    }

    @Override
    public long getImagesCount() {
        return imagesRepository.count();
    }
}
