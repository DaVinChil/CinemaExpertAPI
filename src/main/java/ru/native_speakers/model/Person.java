package ru.native_speakers.model;

import jakarta.persistence.*;
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
    private String imdbId;

    @Column(name = "full_name")
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
