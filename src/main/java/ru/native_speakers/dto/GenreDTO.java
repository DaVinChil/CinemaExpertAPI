package ru.native_speakers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

    @NotNull(message = "Genre's name should not be null")
    @NotEmpty(message = "Genre's name should not be empty")
    private String name;

    private List<MovieDTO> movies;

    public void addMovie(MovieDTO movie){
        if(movies == null){
            movies = new ArrayList<>();
        }

        movies.add(movie);
    }
}
