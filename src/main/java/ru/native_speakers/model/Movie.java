package ru.native_speakers.model;

import jakarta.persistence.*;
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
    private String imdbId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "running_time_in_minutes")
    private int runningTimeInMinutes;

    @Column(name = "chart_rating")
    private double chartRating;
    @Column(name = "year")
    private int year;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    private Image image;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "movies_directors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> directors;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "movies_writers",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> writers;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "movies_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> actors;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    private List<Character> characters;

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.PERSIST)
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
