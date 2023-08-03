package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {

    @NotNull(message = "Image's height should not be null")
    private int height;

    @NotNull(message = "Image's width should not be null")
    private int width;

    @NotNull(message = "Image's url should not be null")
    @NotEmpty(message = "Image's url should not be empty")
    @URL(message = "Image's url should not be incorrect")
    private String url;
}
