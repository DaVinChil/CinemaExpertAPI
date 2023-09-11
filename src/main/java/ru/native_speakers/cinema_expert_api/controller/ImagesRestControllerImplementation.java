package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.ImageDTO;
import ru.native_speakers.cinema_expert_api.service.ImagesService;

import java.util.List;

import static ru.native_speakers.cinema_expert_api.util.ConverterModelToDTO.convertImageToImageDTO;

@RestController
public class ImagesRestControllerImplementation implements ImagesController {

    private final ImagesService imagesService;

    public ImagesRestControllerImplementation(@Qualifier("imagesServiceImpl") ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @Override
    public HttpEntityResponse<ImageDTO> findImageByImageId(long imageId) {
        return new HttpEntityResponse<>(convertImageToImageDTO(imagesService.findImageByImageId(imageId)));
    }

    @Override
    public HttpEntityResponse<List<ImageDTO>> findImages(int pageSize, int page) {
        return new HttpEntityResponse<>(convertImageToImageDTO(imagesService.findImages(pageSize, page)));
    }
}
