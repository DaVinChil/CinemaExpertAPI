package ru.native_speakers.cinema_expert_api.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Image;
import ru.native_speakers.cinema_expert_api.repository.ImagesRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ImagesServiceImplTest {

    @Mock
    private Image image;

    @Mock
    private ImagesRepository imagesRepository;

    @InjectMocks
    private ImagesServiceImpl imagesService;

    @Test
    void findImageByImageId_ReturnsImageClassIfRepositoryReturnsPresentOptional() {
        when(imagesRepository.findById(anyLong())).thenReturn(Optional.of(image));

        long imageId = 2;
        assertThat(imagesService.findImageByImageId(imageId)).isInstanceOf(Image.class);
    }

    @Test
    void findImageByImageId_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyOptional() {
        when(imagesRepository.findById(anyLong())).thenReturn(Optional.empty());

        long imageId = 2;
        assertThrows(EntityNotFoundException.class, () -> imagesService.findImageByImageId(imageId));
    }
}
