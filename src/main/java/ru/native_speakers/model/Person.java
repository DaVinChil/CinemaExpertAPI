package ru.native_speakers.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "imdb_id")
    @NotNull(message = "Person's imdb id should not be null")
    @NotEmpty(message = "Person's imdb id should not be empty")
    @Pattern(regexp = "nm\\d{7}", message = "Person's imdb id should match: nm1234567")
    private String imdbId;

    @Column(name = "full_name")
    @NotNull(message = "Person's full name should not be null")
    @NotEmpty(message = "Person's full name should not be empty")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "height")
    private double height;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "death_date")
    @Temporal(TemporalType.DATE)
    private Date deathDate;

    @Column(name = "death_cause")
    private String deathCause;

    @Column(name = "death_place")
    private String deathPlace;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "photo_id", referencedColumnName = "image_id")
    @NotNull(message = "Person's photo should not be null")
    private Image photo;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.PERSIST)
    private List<Character> characters;

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.PERSIST)
    private List<Movie> filmography;

    public void addCharacter(Character character){
        if(characters == null){
            characters = new ArrayList<>();
        }

        characters.add(character);
    }
}
