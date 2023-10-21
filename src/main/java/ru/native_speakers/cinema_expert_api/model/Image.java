package ru.native_speakers.cinema_expert_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long id;

    @Column(name = "height")
    @NotNull(message = "Image's height should not be null")
    private int height;

    @Column(name = "width")
    @NotNull(message = "Image's width should not be null")
    private int width;

    @Column(name = "url")
    @NotBlank(message = "Image's url should contains at least one character")
    @URL(message = "Image's url should not be incorrect")
    private String url;
}
