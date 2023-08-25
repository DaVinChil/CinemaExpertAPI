package ru.native_speakers.cinema_expert_api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.ImageDTO;
import ru.native_speakers.cinema_expert_api.model.Image;
import ru.native_speakers.cinema_expert_api.service.ImagesService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ImagesRestControllerImplementation implements ImagesController {

    private final ImagesService imagesService;
    private final ModelMapper modelMapper;

    public ImagesRestControllerImplementation(@Qualifier("imagesServiceImpl") ImagesService imagesService,
                                              ModelMapper modelMapper) {
        this.imagesService = imagesService;
        this.modelMapper = modelMapper;
    }

    @Override
    public HttpEntityResponse<ImageDTO> getImageByImageId(long imageId) {
        return new HttpEntityResponse<>(convertImageToImageDTO(imagesService.findImageByImageId(imageId)));
    }

    @Override
    public HttpEntityResponse<List<ImageDTO>> getImages(int pageSize, int page) {
        return new HttpEntityResponse<>(convertImageToImageDTO(imagesService.findImages(pageSize, page)));
    }

    @Override
    public ImageDTO convertImageToImageDTO(Image image) {
        return modelMapper.map(image, ImageDTO.class);
    }

    @Override
    public List<ImageDTO> convertImageToImageDTO(List<Image> images) {
        List<ImageDTO> imageDTOS = new ArrayList<>();
        images.forEach(image -> imageDTOS.add(convertImageToImageDTO(image)));
        return imageDTOS;
    }
}
