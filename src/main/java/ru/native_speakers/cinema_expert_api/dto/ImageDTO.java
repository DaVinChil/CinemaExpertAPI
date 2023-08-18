package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {

    @NotNull(message = "Image's id should not be bull")
    private long id;

    @NotNull(message = "Image's height should not be null")
    private int height;

    @NotNull(message = "Image's width should not be null")
    private int width;

    @NotBlank(message = "Image's url should contains at least one character")
    @URL(message = "Image's url should not be incorrect")
    private String url;
}
