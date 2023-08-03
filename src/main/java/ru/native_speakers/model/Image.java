package ru.native_speakers.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    private int id;

    @Column(name = "height")
    @NotNull(message = "Image's height should not be null")
    private int height;

    @Column(name = "width")
    @NotNull(message = "Image's width should not be null")
    private int width;

    @Column(name = "url")
    @NotNull(message = "Image's url should not be null")
    @NotEmpty(message = "Image's url should not be empty")
    @URL(message = "Image's url should not be incorrect")
    private String url;
}
