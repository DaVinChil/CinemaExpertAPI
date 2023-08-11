package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Image;
import ru.native_speakers.cinema_expert_api.repository.ImagesRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImagesServiceImplementation implements ImagesService {

    private final ImagesRepository imagesRepository;

    @Override
    public Image findImageByImageId(int imageId) throws EntityNotFoundException {
        Optional<Image> imageOptional = imagesRepository.findById(imageId);
        if (imageOptional.isEmpty()) {
            throw new EntityNotFoundException("Image with this id not found");
        }
        return imageOptional.get();
    }

    @Override
    public List<Image> findImages(int count) {
        return imagesRepository.findAll(count);
    }

    @Override
    public long getImagesCount() {
        return imagesRepository.count();
    }
}
