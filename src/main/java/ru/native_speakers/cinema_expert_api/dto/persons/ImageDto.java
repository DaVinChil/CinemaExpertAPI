package ru.native_speakers.cinema_expert_api.dto.persons;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ImageDto {
    private int id;
    private int height;
    private int width;
    private String url;
}
