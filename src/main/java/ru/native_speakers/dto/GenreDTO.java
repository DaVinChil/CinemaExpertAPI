package ru.native_speakers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

    private String name;
    private List<MovieDTO> movies;

    public void addMovie(MovieDTO movie){
        if(movies == null){
            movies = new ArrayList<>();
        }

        movies.add(movie);
    }
}
