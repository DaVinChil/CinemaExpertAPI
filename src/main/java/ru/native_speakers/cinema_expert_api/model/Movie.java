package ru.native_speakers.cinema_expert_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "imdb_id")
    @NotNull(message = "Movie's imdb id should not be null")
    @NotEmpty(message = "Movie's imdb id should not be empty")
    @Pattern(regexp = "tt\\d{7}", message = "Movie's imdb id should be match: tt1234567")
    private String imdbId;

    @Column(name = "title")
    @NotNull(message = "Movie's title should not be null")
    @NotEmpty(message = "Movie's title should not be empty")
    private String title;

    @Column(name = "description")
    @NotNull(message = "Movie's description should not be null")
    private String description;

    @Column(name = "running_time_in_minutes")
    @NotNull(message = "Movie's running should not be null")
    private int runningTimeInMinutes;

    @Column(name = "chart_rating")
    @NotNull(message = "Movie's rating should not be null")
    private double chartRating;

    @Column(name = "year")
    @NotNull(message = "Movie's year should not be null")
    private int year;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    @NotNull(message = "Movie's image should not be null")
    private Image image;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "movies_directors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    @NotNull(message = "Movie's directors should not be null")
    private List<Person> directors;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "movies_writers",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    @NotNull(message = "Movie's writers should not be null")
    private List<Person> writers;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "movies_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    @NotNull(message = "Movie's actors should not be null")
    private List<Person> actors;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    @NotNull(message = "Movie's characters should not be null")
    private List<Character> characters;

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.PERSIST)
    @NotNull(message = "Movie's genres should not be null")
    private List<Genre> genres;

    public void addGenre(Genre genre) {
        if(genres == null){
            genres = new ArrayList<>();
        }

        genres.add(genre);
    }
    public void addCharacter(Character character){
        if(characters == null){
            characters = new ArrayList<>();
        }

        characters.add(character);
    }

    public void addActor(Person person){
        if(actors == null){
            actors = new ArrayList<>();
        }

        actors.add(person);
    }

    public void addDirector(Person person){
        if(directors == null){
            directors = new ArrayList<>();
        }

        directors.add(person);
    }

    public void addWriter(Person person){
        if(writers == null){
            writers = new ArrayList<>();
        }

        writers.add(person);
    }
}
