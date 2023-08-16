package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.ImageDTO;
import ru.native_speakers.cinema_expert_api.model.Image;

import java.util.List;


@RequestMapping("/images")
@Validated
public interface ImagesController {

    @GetMapping("/{id}")
    HttpEntityResponse<ImageDTO> getImageByImageId(@PathVariable("id") @Min(value = 1, message = "Image id cannot be less than 1")
                                              int id);

    @GetMapping
    HttpEntityResponse<ImageDTO> getImages(@RequestParam(name = "page_size")
                                           @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
                                           @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 1")
                                           int pageSize,
                                           @RequestParam(name = "page")
                                           @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
                                           int page);

    ImageDTO convertImageToImageDTO(Image image);
    List<ImageDTO> convertImageToImageDTO(List<Image> images);
}
